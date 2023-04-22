import lombok.ToString;

import java.util.ArrayList;

@ToString
public class Campeonato {
    private ArrayList<PartidoJugado> partidos;

    public Campeonato() {
        this.partidos = new ArrayList<>();
    }

    public ArrayList<PartidoJugado> getPartidos() {
        return partidos;
    }

    public void agregarPartido(PartidoJugado nuevo){
        partidos.add(nuevo);
    }

    public PartidoJugado buscar(String equipoLocal, String equipoVisitante, int fecha){
        for(PartidoJugado partJugado : partidos) {
            if (partJugado.getEquipoLocal().equals(equipoLocal)
                    && partJugado.getEquipoVisitante().equals(equipoVisitante)
                    && partJugado.getFecha() == fecha) {
                return partJugado;
            }
        }
        return null;
    }
}
