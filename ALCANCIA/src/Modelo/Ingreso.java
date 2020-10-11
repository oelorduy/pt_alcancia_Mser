package Modelo;

public class Ingreso {

    private int cod_ingreso;
    private int cincuenta;
    private int cien;
    private int doscientos;
    private int quinientos;
    private int mil;

    public int getCod_ingreso() {
        return cod_ingreso;
    }

    public void setCod_ingreso(int cod_ingreso) {
        this.cod_ingreso = cod_ingreso;
    }

    public int getCincuenta() {
        return cincuenta;
    }

    public void setCincuenta(int cincuenta) {
        this.cincuenta = cincuenta;
    }

    public int getCien() {
        return cien;
    }

    public void setCien(int cien) {
        this.cien = cien;
    }

    public int getDoscientos() {
        return doscientos;
    }

    public void setDoscientos(int doscientos) {
        this.doscientos = doscientos;
    }

    public int getQuinientos() {
        return quinientos;
    }

    public void setQuinientos(int quinientos) {
        this.quinientos = quinientos;
    }

    public int getMil() {
        return mil;
    }

    public void setMil(int mil) {
        this.mil = mil;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    private int total;

}
