package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    private String nombre;
    private String directorTecnico;
    private String entidadRepresentada;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores = new ArrayList<>();

    @ManyToMany
    private List<Torneo> torneos = new ArrayList<>();
    // Getters y Setters


    public Equipo(Long id, String nombre, String directorTecnico, String entidadRepresentada, List<Jugador> jugadores, List<Torneo> torneos) {
        this.id = id;
        this.nombre = nombre;
        this.directorTecnico = directorTecnico;
        this.entidadRepresentada = entidadRepresentada;
        this.jugadores = jugadores;
        this.torneos = torneos;
    }

    public Equipo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public String getEntidadRepresentada() {
        return entidadRepresentada;
    }

    public void setEntidadRepresentada(String entidadRepresentada) {
        this.entidadRepresentada = entidadRepresentada;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        this.torneos = torneos;
    }
}