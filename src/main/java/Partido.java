import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Partido {
    protected int fecha;
    protected String equipoLocal;
    protected String equipoVisitante;

    public Partido(int fecha, String equipoLocal, String equipoVisitante) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }
}
