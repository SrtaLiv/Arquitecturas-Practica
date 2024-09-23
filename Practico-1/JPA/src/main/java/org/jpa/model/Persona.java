package org.jpa.model;
import javax.persistence.*;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "anios")
    private int edad;

    //muchos domicilios pueden estar asociados a una persona.
    //pero una persona no puede tener muchos domicilios
    @ManyToOne
    @JoinColumn(name = "domicilio_id")  // nombre de la columna en la tabla Persona que referencia a Direccion
    private Direccion domicilio;
    public Persona() {
    }

    public Persona(String nombre, int edad, Direccion domicilio) {
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", domicilio=" + domicilio +
                '}';
    }
}
