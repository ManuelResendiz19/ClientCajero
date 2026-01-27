
package com.MResendizCajeroClient.MResendizCajeroClient.ML;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cajeros {

    @JsonProperty("IdCajero")
    private int idCajero;

    @JsonProperty("Estado")
    private String estado;

    @JsonProperty("Ubicacion")
    private String ubicacion;

    @JsonProperty("CapacidadMax")
    private int capacidadMax;

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }
    
}