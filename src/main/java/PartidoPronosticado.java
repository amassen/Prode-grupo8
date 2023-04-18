import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PartidoPronosticado extends Partido {
    private String nombre;
    private ResultadoEnum resultadoPron;

    public PartidoPronosticado(String nombre, int ronda, String equipoLocal, String equipoVisitante, ResultadoEnum resultadoPron) {
        super(ronda, equipoLocal, equipoVisitante);
        this.nombre = nombre;
        this.resultadoPron = resultadoPron;
    }

    public void mostrarPartidoPronosticado() {
        System.out.println("Jugador: "+nombre+" Ronda: "+ronda+" - "+equipoLocal + " vs. " + equipoVisitante + " = " + resultadoPron);
    }


}