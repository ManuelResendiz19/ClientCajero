
package com.MResendizCajeroClient.MResendizCajeroClient.ML;


public class Cuenta {

    private int IdCuenta;

    private String NoCuenta;

    private Float Saldo;

    private String PIN;

    private TipoCuenta tipoCuenta;

    private Usuario usuario;

    private EstadoCuenta estado;

    public Cuenta() {
    }

    public Cuenta(int IdCuenta, String NoCuenta, Float Saldo, String PIN, TipoCuenta tipoCuenta, Usuario usuario, EstadoCuenta estado) {
        this.IdCuenta = IdCuenta;
        this.NoCuenta = NoCuenta;
        this.Saldo = Saldo;
        this.PIN = PIN;
        this.tipoCuenta = tipoCuenta;
        this.usuario = usuario;
        this.estado = estado;
    }

    public String getNoCuenta() {
        return NoCuenta;
    }

    public void setNoCuenta(String NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    public Float getSaldo() {
        return Saldo;
    }

    public void setSaldo(Float Saldo) {
        this.Saldo = Saldo;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }
}
