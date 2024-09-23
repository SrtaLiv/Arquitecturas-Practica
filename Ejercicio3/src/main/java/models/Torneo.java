package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Torneo {
    @Id
    @GeneratedValue
    private int id;

    private String nombre;

    @ManyToMany(mappedBy = "torneos")
    private List<Equipo> equipos = new ArrayList<>();

    public Torneo() {
    }

    public Torneo(int id, String nombre, List<Equipo> equipos) {
        this.id = id;
        this.nombre = nombre;
        this.equipos = equipos;
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

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}
