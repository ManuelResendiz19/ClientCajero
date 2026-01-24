
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class Usuario {    
    private int IdUsuario;
    
    private String Nombre;
    
    private String ApellidoPaterno;
    
    private String ApellidoMaterno;
    
    private String userName;
    
    private String Password;
    
    private Rol rol;

    public Usuario() {
    }
    
        public Usuario(int IdUsuario, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String userName, String Password, Rol rol) {
            this.IdUsuario = IdUsuario;
            this.Nombre = Nombre;
            this.ApellidoPaterno = ApellidoPaterno;
            this.ApellidoMaterno = ApellidoMaterno;
            this.userName = userName;
            this.Password = Password;
            this.rol = rol;
        }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
       
}