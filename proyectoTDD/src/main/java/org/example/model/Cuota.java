package org.example.model;

import org.example.exceptions.*;

import java.time.LocalDate;

public class Cuota {
    private int mes;
    private int anio;
    private double monto;
    private boolean pagada;

    private Cuota(int mes, int anio, double monto, boolean pagada){
        this.mes = mes;
        this.anio = anio;
        this.monto = monto;
        this.pagada = pagada;
    }

    public static Cuota instance(int mes, int anio, double monto){
        if (mes < 0 || mes > 12){
            throw new ExceptionCuotaMesInvalido("El mes ingresado no puede ser manor a 1 ni mayor a 12.");
        }
        if (anio < 2025 || anio > 2027){
            throw new ExceptionCuotaAnioInvalido("El anio ingresado no puede superar el año de vigencia.");
        }
        if (monto <= 0){
            throw new ExceptionCuotaMontoInvalido("El monto ingresado no puede ser menor o igual a cero.");
        }

        return new Cuota(mes, anio, monto, false);
    }
    public int getMes() {
        return mes;
    }
    public int getAnio() {
        return anio;
    }
    public double getMonto() {
        return monto;
    }
    public boolean isPagada() {
        return pagada;
    }
    public String toString(){
        return "";
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public int hashCode(){
        return super.hashCode();
    }
}
