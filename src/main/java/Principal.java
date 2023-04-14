import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Path resultados = Paths.get("resultados.csv");
        Scanner lectorResultado = new Scanner(resultados);

        lectorResultado.useDelimiter("[;\\n\\r]+");

        ArrayList<PartidoJugado> resultadosArray = new ArrayList<>();
        ResultadoEnum resultTemp;
        while (lectorResultado.hasNext()) {
            String localTemp = lectorResultado.next();
            int golLocalTemp = lectorResultado.nextInt();
            int golVisitaTemp = lectorResultado.nextInt();
            String visitaTemp = lectorResultado.next();

            if (golLocalTemp > golVisitaTemp) {
                resultTemp = ResultadoEnum.LOCAL;
            } else {
                resultTemp = (golVisitaTemp > golLocalTemp) ? ResultadoEnum.VISITANTE : ResultadoEnum.EMPATE;
            }
            PartidoJugado partidoTemp = new PartidoJugado(localTemp, golLocalTemp, golVisitaTemp, visitaTemp, resultTemp);
            resultadosArray.add(partidoTemp);
        }
        //recorro el array para chequear
        for (PartidoJugado part : resultadosArray) {
            part.mostrarPartidoJugado();
        }

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

        int puntos = 0;
        for (PartidoJugado part : resultadosArray) {
            for (PartidoPronosticado pron : pronosticosArray) {

                if (part.getResultado().equals(pron.getResultadoPron())) {
                    puntos += 1;
                }
            }
        }
        System.out.println("puntos " + puntos);

        lectorResultado.close();
        lectorPronosticos.close();

    }
}

