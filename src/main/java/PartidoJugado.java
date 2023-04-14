import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PartidoJugado extends Partido {
    private int golesLocal;
    private int golesVisita;
    private ResultadoEnum resultado;

    public PartidoJugado(String equipoLocal, int golesLocal, int golesVisita, String equipoVisitante, ResultadoEnum resultado) {
        super(equipoLocal, equipoVisitante);
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
        this.resultado = resultado;
    }

    public void mostrarPartidoJugado() {
        System.out.println(equipoLocal + " Goles Local= " + golesLocal + " | " + equipoVisitante + " goles visitante = " + golesVisita + "| resultado: " + resultado);
    }


}
