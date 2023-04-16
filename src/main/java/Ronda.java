import java.util.ArrayList;

public class Ronda {
    private int numero;
    private ArrayList<PartidoJugado> partidos;

    public Ronda(int numero, ArrayList<PartidoJugado> partidos) {
        this.numero = numero;
        this.partidos = new ArrayList<>();
    }

    public void agregarPartido(PartidoJugado nuevo){
        partidos.add(nuevo);
    }

}
