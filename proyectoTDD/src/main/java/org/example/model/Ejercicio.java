package org.example.model;

import org.example.exceptions.*;

public class Ejercicio {
    private String nombre;
    private int series;
    private int repeticiones;
    private int kilos;
    private int descanso;

    private Ejercicio(String nombre,
                      int series,
                      int repeticiones,
                      int kilos,
                      int descanso) {
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.kilos = kilos;
        this.descanso = descanso;
    }

    public static Ejercicio instance(String nombre,
                                     int series,
                                     int repeticiones,
                                     int kilos,
                                     int descanso) {
        if (nombre == null) {
            throw new ExceptionEjercicioNombreNull("El nombre no puede ser null.");
        }
        if (nombre.isEmpty()){
            throw new ExceptionEjercicioNombreVacio("El nombre no puede estar vacio.");
        }
        if (series < 0){
            throw new ExceptionEjercicioSeriesNegativas("La cantidad de series no puede ser negativa.");
        }
        if (repeticiones < 0){
            throw new ExceptionEjercicioRepeticionesNegativas("La cantidad de repeticiones no puede ser negativa.");
        }
        if (kilos < 0){
            throw new ExceptionEjercicioKilosNegativos("Los kilos no pueden ser negativos.");
        }
        if (descanso < 0){
            throw new ExceptionEjercicioDescansoNegativo("El dencanso no puede ser negativo.");
        }

        return new Ejercicio(nombre, series, repeticiones, kilos, descanso);
    }

    public String getNombre() {
        return nombre;
    }
    public int getSeries() {
        return series;
    }
    public int getRepeticiones() {
        return repeticiones;
    }
    public int getKilos() {
        return kilos;
    }
    public int getDescanso() {
        return descanso;
    }
    @Override
    public String toString() {
        return "";
    }


}
