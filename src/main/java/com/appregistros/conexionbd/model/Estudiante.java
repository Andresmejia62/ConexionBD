package com.appregistros.conexionbd.model;

import java.time.LocalDate;
import java.math.BigDecimal;

public class Estudiante {
    private int id;
    private String Nombre;
    private String Correo;
    private String carrera;
    private String telefono;
    private int edad;
    private LocalDate fechaIngreso;
    private BigDecimal promedio;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, String correo, String carrera, String telefono,
                      int edad, LocalDate fechaIngreso, BigDecimal promedio) {
        this.id = id;
        Nombre = nombre;
        Correo = correo;
        this.carrera = carrera;
        this.telefono = telefono;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.promedio = promedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }
}