import lombok.ToString;

import java.util.ArrayList;

@ToString
public class Jugador {
    private String nombre;
    private ArrayList<PartidoPronosticado> pronosticos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPartido(PartidoPronosticado nuevo){
        pronosticos.add(nuevo);
    }

    public int puntosTotal(Campeonato campeonato) {
        int puntaje = 0;
        for (PartidoPronosticado pronostico : pronosticos) {
            PartidoJugado partidoJugado = campeonato.buscar(
                    pronostico.getEquipoLocal(),
                    pronostico.getEquipoVisitante(),
                    pronostico.getFecha());
            if (pronostico.getResultadoPron().equals(partidoJugado.resultado())) {
                puntaje++;
            }
        }
        return puntaje;
    }
}
