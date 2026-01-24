
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class Transacciones {
    
    private int IdTransaccion;
    
    private String NoCuenta;
    
    private float Monto;
    
    private Cajeros cajeros;

    public Transacciones() {
    }

    public Transacciones(int IdTransaccion, String NoCuenta, float Monto, Cajeros cajeros) {
        this.IdTransaccion = IdTransaccion;
        this.NoCuenta = NoCuenta;
        this.Monto = Monto;
        this.cajeros = cajeros;
    }
    
    public int getIdTransaccion() {
        return IdTransaccion;
    }

    public void setIdTransaccion(int IdTransaccion) {
        this.IdTransaccion = IdTransaccion;
    }

    public String getNoCuenta() {
        return NoCuenta;
    }

    public void setNoCuenta(String NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public Cajeros getCajeros() {
        return cajeros;
    }

    public void setCajeros(Cajeros cajeros) {
        this.cajeros = cajeros;
    }
}
