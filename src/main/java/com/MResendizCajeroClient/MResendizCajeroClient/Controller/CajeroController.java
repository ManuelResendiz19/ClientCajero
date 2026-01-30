package com.MResendizCajeroClient.MResendizCajeroClient.Controller;

import com.MResendizCajeroClient.MResendizCajeroClient.DTO.LoginRequest;
import com.MResendizCajeroClient.MResendizCajeroClient.DTO.LoginResponse;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.Cajeros;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.Cuenta;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.InventarioCajero;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.Result;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.TDenominacion;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.Transacciones;
import com.MResendizCajeroClient.MResendizCajeroClient.ML.Usuario;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("cajero")
public class CajeroController {

    private static final String urlBase = "http://localhost:8080";

    @GetMapping
    public String index(Model model, HttpSession session) {

        String token = (String) session.getAttribute("token");

        if (token == null) {
            return "redirect:/cajero/login";
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<Result<List<Cajeros>>> response
                = restTemplate.exchange(
                        urlBase + "/api/Cajeros",
                        HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<Result<List<Cajeros>>>() {
                }
                );

        if (response.getStatusCode().is2xxSuccessful()
                && response.getBody() != null
                && response.getBody().correct) {

            model.addAttribute("cajeros", response.getBody().object);
        } else {
            model.addAttribute("cajeros", List.of());
        }

        return "CajerosIndex";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "LoginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest,
            HttpSession session,
            Model model) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequest> request
                = new HttpEntity<>(loginRequest, headers);

        ResponseEntity<LoginResponse> response;

        try {
            response = restTemplate.postForEntity(
                    urlBase + "/api/auth/login",
                    request,
                    LoginResponse.class
            );
        } catch (Exception e) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "LoginForm";
        }

        LoginResponse usuario = response.getBody();

        if (usuario == null || usuario.getToken() == null) {
            model.addAttribute("error", "Credenciales inválidas");
            return "LoginForm";
        }

        session.setAttribute("token", usuario.getToken());
        session.setAttribute("rol", usuario.getRol());

        return "redirect:/cajero";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/cajero/login";
    }

    @GetMapping("/detail/{IdCajero}")
    public String Detail(
            @PathVariable("IdCajero") int IdCajero,
            Model model,
            HttpSession session) {

        Object tokenObj = session.getAttribute("token");
        if (tokenObj == null) {
            return "redirect:/login";
        }
        String token = tokenObj.toString();

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            model.addAttribute("rol", usuario.getRol().getNombreRol());
        } else {
            model.addAttribute("rol", "USER");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Result<Cajeros>> responseEntity = restTemplate.exchange(
                    urlBase + "/api/Cajeros/" + IdCajero,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<Result<Cajeros>>() {
            });

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                Result<Cajeros> result = responseEntity.getBody();
                if (result != null && result.correct) {
                    model.addAttribute("cajero", result.object);
                } else {
                    model.addAttribute("errorMessage", result != null ? result.errorMessage : "Error al obtener el cajero");
                }
            } else {
                model.addAttribute("errorMessage", "Error de conexión al servicio");
            }

        } catch (Exception e) {
            model.addAttribute("errorMessage", "No se pudo conectar con el servicio.");
        }

        model.addAttribute("token", token);
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("transaccion", new Transacciones());
        model.addAttribute("inventarioCajero", new InventarioCajero());
        model.addAttribute("TDenominacion", new TDenominacion());

        return "CajeroDetail";
    }

}
