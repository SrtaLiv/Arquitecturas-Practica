package org.jpa.practico3.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String ciudad;
    @Column
    private String calle;

    @OneToMany(mappedBy="domicilio", fetch=FetchType.LAZY) //avisa que ya esta mapeada! en Persona
    private List<Persona> habitante;

    public Direccion() {
        super();
        this.habitante = new ArrayList<Persona>();
    }

    public Direccion(String ciudad, String calle) {
        super();
        this.ciudad = ciudad;
        this.calle = calle;
    }


}