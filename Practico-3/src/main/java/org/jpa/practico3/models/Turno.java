package org.jpa.practico3.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Turno {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Timestamp fecha;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Persona> jugadores; //Mapped by jugadores en prsona

    public Turno() {
        super();
    }

    public Turno(Timestamp fecha) {
        super();
        this.fecha = fecha;
        this.jugadores = new ArrayList<Persona>();
    }


}
