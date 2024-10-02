package org.jpa.practico3.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data //getters
public class Socio {

    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Persona persona;

    @Column
    private String tipo;

    public Socio() {
        super();
    }

    public Socio(Persona persona, String tipo) {
        super();
        //this.id = persona.getId();
        this.persona = persona;
        this.tipo = tipo;
    }

}

