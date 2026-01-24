
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class TipoCuenta {
    
    private int IdTCuenta;

    private String Tipo;

    public TipoCuenta() {
    }

    public TipoCuenta(int IdTCuenta, String Tipo) {
        this.IdTCuenta = IdTCuenta;
        this.Tipo = Tipo;
    }

    public int getIdTCuenta() {
        return IdTCuenta;
    }

    public void setIdTCuenta(int IdTCuenta) {
        this.IdTCuenta = IdTCuenta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
