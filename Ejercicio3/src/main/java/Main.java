import models.Equipo;
import models.Jugador;
import models.Torneo;
import service.EquipoService;
import service.JugadorService;
import service.TorneoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de los servicios
        EquipoService equipoService = new EquipoService();
        JugadorService jugadorService = new JugadorService();
        TorneoService torneoService = new TorneoService();

        /*
        Equipo equipo = new Equipo();
        equipo.setNombre("Boca");
        equipo.setDirectorTecnico("No se");
        equipo.setEntidadRepresentada("Boca Juniots");
        equipoService.crearEquipo(equipo);*/

        System.out.println("Cual es el peor equipo?");
        Equipo peor = equipoService.obtenerEquipo(5L);
        System.out.println(peor.getNombre());
        /*
        // Crear y persistir un nuevo torneo
        Torneo torneo = new Torneo();
        torneo.setNombre("Copa Libertadores");
        torneoService.crearTorneo(torneo);

        // Crear y persistir un nuevo equipo
        Equipo equipo = new Equipo();
        equipo.setNombre("River Plate");
        equipo.setDirectorTecnico("Marcelo Gallardo");
        equipo.setEntidadRepresentada("Club Atlético River Plate");
        equipoService.crearEquipo(equipo);

        // Crear y persistir nuevos jugadores
        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Riquelme");
        jugador1.setPosicion("Defensor");
        jugador1.setEquipo(equipo);
        jugadorService.crearJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Ortega");
        jugador2.setPosicion("Delantero");
        jugador2.setEquipo(equipo);
        jugadorService.crearJugador(jugador2);
*/
        // Listar todos los equipos
        List<Equipo> equipos = equipoService.listarEquipos();
        System.out.println("Equipos:");
        for (Equipo e : equipos) {
            System.out.println(e.getNombre());
        }

        // Listar todos los jugadores
        List<Jugador> jugadores = jugadorService.listarJugadores();
        System.out.println("Jugadores:");
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + " - " + j.getPosicion());
        }

        // Listar todos los torneos
        List<Torneo> torneos = torneoService.listarTorneos();
        System.out.println("Torneos:");
        for (Torneo t : torneos) {
            System.out.println(t.getNombre());
        }

    }
}