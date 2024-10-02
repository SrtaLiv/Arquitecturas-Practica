package org.jpa.practico3.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;



@Entity
@Data
public class Persona {

    @Id
    private int id;

    @Column
    private String nombre;

    @Column
    private int edad;

    @ManyToOne //muchas personas van a una direccion
    private Direccion domicilio;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "jugadores") //lista en turno
    private List<Turno> turnos;

    public Persona() {
        super();
    }

    public Persona(int id, String nombre, int edad, Direccion domicilio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
    }


}