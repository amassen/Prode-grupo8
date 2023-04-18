import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerResultado {
    public static ArrayList<PartidoJugado> leerResultados() throws IOException {
        Path resultados = Paths.get("resultados.csv");
        Scanner lectorResultado = new Scanner(resultados);

        lectorResultado.useDelimiter("[;\\n\\r]+");

        ArrayList<PartidoJugado> resultadosArray = new ArrayList<>();
        ResultadoEnum resultTemp;
        while (lectorResultado.hasNextInt()) {
            int rondaTemp = lectorResultado.nextInt();
            String localTemp = lectorResultado.next();
            int golLocalTemp = lectorResultado.nextInt();
            int golVisitaTemp = lectorResultado.nextInt();
            String visitaTemp = lectorResultado.next();

            if (golLocalTemp > golVisitaTemp) {
                resultTemp = ResultadoEnum.LOCAL;
            } else {
                resultTemp = (golVisitaTemp > golLocalTemp) ? ResultadoEnum.VISITANTE : ResultadoEnum.EMPATE;
            }
            PartidoJugado partidoTemp = new PartidoJugado(rondaTemp, localTemp, golLocalTemp, golVisitaTemp, visitaTemp, resultTemp);
            resultadosArray.add(partidoTemp);
        }
        //recorro el array para chequear
//        for (PartidoJugado part : resultadosArray) {
//            part.mostrarPartidoJugado();
//        }

        lectorResultado.close();
        return resultadosArray;
    }
}
