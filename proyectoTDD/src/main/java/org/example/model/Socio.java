package org.example.model;

import org.example.exceptions.*;

import java.time.LocalDate;
import java.util.Objects;

public class Socio {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private Genero miGenero;
    private double altura;
    private double peso;

    private Socio(String nombre,
                  String apellido,
                  String dni,
                  LocalDate fechaNacimiento,
                  Genero miGenero,
                  double altura,
                  double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.miGenero = miGenero;
        this.altura = altura;
        this.peso = peso;
    }

    public static Socio instance(String nombre,
                                 String apellido,
                                 String dni,
                                 LocalDate fechaNacimiento,
                                 Genero miGenero,
                                 double altura,
                                 double peso){
        if (nombre == null) {
            throw new ExceptionSocioNombreNull("El nombre no puede ser nulo.");
        }
        if (nombre.isEmpty()) {
            throw new ExceptionSocioNombreVacio("El nombre no puede estar vacio.");
        }
        if (apellido == null) {
            throw new ExceptionSocioApellidoNull("El apellido no puede ser nulo.");
        }
        if (apellido.isEmpty()) {
            throw new ExceptionSocioApellidoVacio("El apellido no puede estar vacio.");
        }
        if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new ExceptionSocioFechaInvalida("La fecha de nacimiento no puede ser futura.");
        }
        if (dni.length() < 7 || dni.length() > 8) {
            throw new ExceptionSocioDNIInvalido("El DNI debe tener 7 u 8 numeros.");
        }
        if (altura > 2.2){
            throw new ExceptionSocioAlturaInvalida("La altura ingresada no es valida.");
        }
        if (altura < 0){
            throw new ExceptionSocioAlturaInvalida("La altura ingresada no puede ser menor a cero.");
        }
        if (peso < 40){
            throw new ExceptionSocioPesoInvalido("El peso ingresado no es valido.");
        }
        if (miGenero == null){
            throw new ExceptionSocioGeneroInvalido("El genero ingresado no es valido.");
        }

        return new Socio(nombre, apellido, dni, fechaNacimiento, miGenero, altura, peso);
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDni() {
        return dni;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public Genero getGenero() {
        return miGenero;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }
    @Override
    public String toString() {
        return "";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, dni);
    }

}
