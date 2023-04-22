import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PartidoPronosticado extends Partido {

    private String nombreJugador;
    private ResultadoEnum resultadoPron;

    public PartidoPronosticado(String nombreJugador, int fecha, String equipoLocal, String equipoVisitante, ResultadoEnum resultadoPron) {
        super(fecha, equipoLocal, equipoVisitante);
        this.nombreJugador = nombreJugador;
        this.resultadoPron = resultadoPron;
    }

    public void mostrarPartidoPronosticado() {
        System.out.println("Jugador: "+nombreJugador+" Ronda: "+fecha+" - "+equipoLocal + " vs. " + equipoVisitante + " = " + resultadoPron);
    }


}