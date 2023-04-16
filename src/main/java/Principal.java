import java.io.IOException;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) throws IOException {

        LeerResultado.leerResultados();

        LeerPronostico.leerPronosticos();

        ArrayList<PartidoJugado> resultadosArray = LeerResultado.leerResultados();

        ArrayList<PartidoPronosticado> pronosticosArray = LeerPronostico.leerPronosticos();

        int puntosFecha = 0;

        for (PartidoJugado partJugado : resultadosArray) {
            for (PartidoPronosticado partPronosticado : pronosticosArray) {
                if (partJugado.getEquipoLocal().equals(partPronosticado.getEquipoLocal()) && partJugado.getResultado().equals(partPronosticado.getResultadoPron())) {
                    puntosFecha += 1;
                    break;
                }
            }
        }
       System.out.println("Total de aciertos: " + puntosFecha + " Los puntos conseguidos hasta ahora son: " + puntosFecha);


    }
}

