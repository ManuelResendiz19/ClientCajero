
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class EstadoCuenta {
    
    private int IdEstado;
    
    private String NombreEstado;

    public EstadoCuenta() {
    }

    public EstadoCuenta(int IdEstado, String NombreEstado) {
        this.IdEstado = IdEstado;
        this.NombreEstado = NombreEstado;
    }

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String getNombreEstado() {
        return NombreEstado;
    }

    public void setNombreEstado(String NombreEstado) {
        this.NombreEstado = NombreEstado;
    }
    
}
