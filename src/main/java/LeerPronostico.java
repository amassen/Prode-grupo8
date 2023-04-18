import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerPronostico {

    public static ArrayList<PartidoPronosticado> leerPronosticos() throws IOException {
        Path pronosticos = Paths.get("pronosticos.csv");
        Scanner lectorPronosticos = new Scanner(pronosticos);

        lectorPronosticos.useDelimiter("[;\\n\\r]+");
        ArrayList<PartidoJugado> resultadosArray = LeerResultado.leerResultados();
        ArrayList<PartidoPronosticado> pronosticosArray = new ArrayList<>();

        ResultadoEnum resultadoTemp;

        while (lectorPronosticos.hasNext()) {
            String nombreTemp = lectorPronosticos.next();
            String eqLocalTemp = lectorPronosticos.next();
            String localTemp = lectorPronosticos.next();
            String empateTemp = lectorPronosticos.next();
            String visitaTemp = lectorPronosticos.next();
            String eqVisitaTemp = lectorPronosticos.next();

            // para ver si recolecta bien los datos
            //System.out.println("Nombre: "+nombre+ " - local: " + eqLocalTemp + " L: " + localTemp + " E: " + empateTemp + " V: " + visitaTemp + " visitante: " + eqVisitaTemp);

            if (localTemp.contains("X")) {
                resultadoTemp = ResultadoEnum.LOCAL;
            } else {
                resultadoTemp = (visitaTemp.contains("X")) ? ResultadoEnum.VISITANTE : ResultadoEnum.EMPATE;
            }
            int rondaTemp =1;
            for (PartidoJugado partJugado : resultadosArray) {
                if (partJugado.getEquipoLocal().equals(eqLocalTemp) && partJugado.getEquipoVisitante().equals(eqVisitaTemp)) {
                    rondaTemp = partJugado.getRonda();
                    break;

                }
            }

            PartidoPronosticado pronosticoTemp = new PartidoPronosticado(nombreTemp,rondaTemp,eqLocalTemp, eqVisitaTemp, resultadoTemp);
            pronosticosArray.add(pronosticoTemp);
            pronosticoTemp.mostrarPartidoPronosticado();
        }

        lectorPronosticos.close();
        return pronosticosArray;
    }
}
