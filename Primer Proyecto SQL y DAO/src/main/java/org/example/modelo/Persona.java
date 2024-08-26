package org.example.modelo;

public class Persona {
    private int id;
    private String nombre;
    private int year;
    public Persona() {}

    public Persona(int id, String nombre, int year) {
        this.id = id;
        this.nombre = nombre;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
