
package com.MResendizCajeroClient.MResendizCajeroClient.Controller;

import com.MResendizCajeroClient.MResendizCajeroClient.DTO.LoginRequest;
import com.MResendizCajeroClient.MResendizCajeroClient.DTO.LoginResponse;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.Cajeros;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.Result;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("cajero")
public class CajeroController {
    
    private static final  String urlBase = "http://localhost:8080";
    
    @GetMapping
    public String Index(Model model, HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + session.getAttribute("token").toString());
        HttpEntity<String> entity = new HttpEntity<>(null, header);

        ResponseEntity<Result<List<Cajeros>>> responseEntity = restTemplate.exchange(urlBase + "/api/Cajeros", HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Result<List<Cajeros>>>() {
        });

        if (responseEntity.getStatusCode().value() == 200) {
            Result<List<Cajeros>> result = responseEntity.getBody();
            model.addAttribute("cajeros", result.object);
        }
               
        return "CajerosIndex";
    }
    
    
    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("loginRequest", new LoginRequest());
        return "LoginForm";
    }
    
    
    @PostMapping("/login")
    public String Login(@ModelAttribute LoginRequest loginRequest, HttpSession session, Model model){
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest);
        
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity(urlBase + "/api/auth/login", request, LoginResponse.class);
     
        session.setAttribute("usuario", response.getBody());

        LoginResponse usuario = response.getBody();
        if (usuario == null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "LoginForm";
        }
        
        String rol = usuario.getRol();
        
        if(rol.equals("ADMIN") || rol.equals("CLIENT")){
            return "CajerosIndex";
        }else{       
            return "LoginForm";
        }
    }
}
