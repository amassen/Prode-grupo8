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
        while (lectorPronosticos.hasNext()) {
            //1;Mariana;Argentina;X; ; ;Arabia Saudita
            String fecha = lectorPronosticos.next();
            String nombreTemp = lectorPronosticos.next();
            String eqLocalTemp = lectorPronosticos.next();
            String localTemp = lectorPronosticos.next();
            String empateTemp = lectorPronosticos.next();
            String visitaTemp = lectorPronosticos.next();
            String eqVisitaTemp = lectorPronosticos.next();

            ResultadoEnum resultadoTemp;
            if (localTemp.contains("X")) {
                resultadoTemp = ResultadoEnum.LOCAL;
            } else {
                resultadoTemp = (visitaTemp.contains("X")) ? ResultadoEnum.VISITANTE : ResultadoEnum.EMPATE;
            }

            PartidoPronosticado partidoPronosticado = new PartidoPronosticado(
                    nombreTemp,
                    Integer.parseInt(fecha),
                    eqLocalTemp,
                    eqVisitaTemp,
                    resultadoTemp);
            pronosticosArray.add(partidoPronosticado);
        }

        lectorPronosticos.close();
        return pronosticosArray;
    }
}
