
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class InventarioCajero {

    private int IdStock;
    
    private Cajeros cajeros;
    
    private int CantidadDisponible;
    
    private TDenominacion tDenominacion;

    public InventarioCajero() {
    }

    public InventarioCajero(int IdStock, Cajeros cajeros, int CantidadDisponible, TDenominacion tDenominacion) {
        this.IdStock = IdStock;
        this.cajeros = cajeros;
        this.CantidadDisponible = CantidadDisponible;
        this.tDenominacion = tDenominacion;
    }
    
    public int getIdStock() {
        return IdStock;
    }

    public void setIdStock(int IdStock) {
        this.IdStock = IdStock;
    }

    public Cajeros getCajerosJPA() {
        return cajeros;
    }

    public void setCajerosJPA(Cajeros cajeros) {
        this.cajeros = cajeros;
    }

    public int getCantidadDisponible() {
        return CantidadDisponible;
    }

    public void setCantidadDisponible(int CantidadDisponible) {
        this.CantidadDisponible = CantidadDisponible;
    }

    public TDenominacion gettDenominacion() {
        return tDenominacion;
    }

    public void settDenominacion(TDenominacion tDenominacion) {
        this.tDenominacion = tDenominacion;
    }

    public Cajeros getCajeros() {
        return cajeros;
    }

    public void setCajeros(Cajeros cajeros) {
        this.cajeros = cajeros;
    }
    
    
}
