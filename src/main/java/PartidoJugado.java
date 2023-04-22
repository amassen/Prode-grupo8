import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PartidoJugado extends Partido {
    private int golesLocal;
    private int golesVisita;

    public PartidoJugado(int fecha, String equipoLocal, int golesLocal, int golesVisita, String equipoVisitante) {
        super(fecha, equipoLocal, equipoVisitante);
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
    }

    public ResultadoEnum resultado() {
        ResultadoEnum resultadoTemp;
        if (golesLocal > golesVisita) {
            resultadoTemp = ResultadoEnum.LOCAL;
        } else {
            resultadoTemp = (golesVisita > golesLocal) ? ResultadoEnum.VISITANTE : ResultadoEnum.EMPATE;
        }
        return resultadoTemp;
    }

    public void mostrarPartidoJugado() {
        System.out.println(equipoLocal + " Goles Local= " + golesLocal + " | " + equipoVisitante + " goles visitante = " + golesVisita + " | resultado: " + resultado());
    }
}
