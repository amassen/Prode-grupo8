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

        ArrayList<PartidoPronosticado> pronosticosArray = new ArrayList<>();

        ResultadoEnum resultadoTemp;

        while (lectorPronosticos.hasNext()) {
            String eqLocalTemp = lectorPronosticos.next();
            String localTemp = lectorPronosticos.next();
            String empateTemp = lectorPronosticos.next();
            String visitaTemp = lectorPronosticos.next();
            String eqVisitaTemp = lectorPronosticos.next();

            // para ver si recolecta bien los datos
            System.out.println("local: " + eqLocalTemp + " L: " + localTemp + " E: " + empateTemp + " V: " + visitaTemp + " visitante: " + eqVisitaTemp);

            if (localTemp.contains("X")) {
                resultadoTemp = ResultadoEnum.LOCAL;
            } else {
                resultadoTemp = (visitaTemp.contains("X")) ? ResultadoEnum.VISITANTE : ResultadoEnum.EMPATE;
            }

            PartidoPronosticado pronosticoTemp = new PartidoPronosticado(eqLocalTemp, eqVisitaTemp, resultadoTemp);
            pronosticosArray.add(pronosticoTemp);
            pronosticoTemp.mostrarPartidoPronosticado();
        }

        lectorPronosticos.close();
        return pronosticosArray;
    }
}
