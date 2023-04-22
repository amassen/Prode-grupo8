import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PartidoJugado extends Partido {
    private int golesLocal;
    private int golesVisitante;

    public PartidoJugado(int fecha, String equipoLocal, int golesLocal, int golesVisitante, String equipoVisitante) {
        super(fecha, equipoLocal, equipoVisitante);
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public ResultadoEnum resultado() {
        ResultadoEnum resultadoTemp;
        if (golesLocal > golesVisitante) {
            resultadoTemp = ResultadoEnum.LOCAL;
        } else {
            resultadoTemp = (golesVisitante > golesLocal) ? ResultadoEnum.VISITANTE : ResultadoEnum.EMPATE;
        }
        return resultadoTemp;
    }

    public void mostrarPartidoJugado() {
        System.out.println(equipoLocal + " Goles Local= " + golesLocal + " | " + equipoVisitante + " goles visitante = " + golesVisitante + " | resultado: " + resultado());
    }
}
