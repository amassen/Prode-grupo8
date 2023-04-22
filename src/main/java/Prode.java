import lombok.ToString;

import java.util.HashMap;
@ToString
public class Prode {
    private HashMap<String, Jugador> jugadores;
    private Campeonato campeonato;

    public Prode(Campeonato campeonato, HashMap<String, Jugador> jugadores){
        this.campeonato = campeonato;
        this.jugadores = jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.put(jugador.getNombre(), jugador);
    }

    public Jugador ganador(){
        Jugador ganador = null;
        int puntajeGanador = 0;
        for (Jugador jugador : jugadores.values()) {
            int puntos = jugador.puntosTotal(campeonato);
            if(puntos > puntajeGanador){
                ganador = jugador;
                puntajeGanador = puntos;
            }
        }
        return ganador;
    }
}
