
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class Cajeros {
    
    private int IdCajero;
    
    private String Estado;
    
    private String Ubicacion;
    
    private int CapacidadMax;

    public Cajeros() {
    }

    public Cajeros(int IdCajero, String Estado, String Ubicacion, int CapacidadMax) {
        this.IdCajero = IdCajero;
        this.Estado = Estado;
        this.Ubicacion = Ubicacion;
        this.CapacidadMax = CapacidadMax;
    }

    public int getIdCajero() {
        return IdCajero;
    }

    public void setIdCajero(int IdCajero) {
        this.IdCajero = IdCajero;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getCapacidadMax() {
        return CapacidadMax;
    }

    public void setCapacidadMax(int CapacidadMax) {
        this.CapacidadMax = CapacidadMax;
    }
}
