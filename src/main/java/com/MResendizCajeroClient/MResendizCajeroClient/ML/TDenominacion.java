
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class TDenominacion {
private int IdDenominacion;
    
    private String TipoDeno;
    
    private float Denominacion;

    public TDenominacion() {
    }

    public TDenominacion(int IdDenominacion, String TipoDeno, float Denominacion) {
        this.IdDenominacion = IdDenominacion;
        this.TipoDeno = TipoDeno;
        this.Denominacion = Denominacion;
    }

    public int getIdDenominacion() {
        return IdDenominacion;
    }

    public void setIdDenominacion(int IdDenominacion) {
        this.IdDenominacion = IdDenominacion;
    }

    public String getTipoDeno() {
        return TipoDeno;
    }

    public void setTipoDeno(String TipoDeno) {
        this.TipoDeno = TipoDeno;
    }

    public float getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(float Denominacion) {
        this.Denominacion = Denominacion;
    }
    
}
