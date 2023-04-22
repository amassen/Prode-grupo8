import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LeerResultado {
    public static Campeonato leerResultados() throws IOException {
        Path resultados = Paths.get("resultados.csv");
        Scanner lectorResultado = new Scanner(resultados);
        lectorResultado.useDelimiter("[;\\n\\r]+");

        Campeonato campeonato = new Campeonato();
        while (lectorResultado.hasNextInt()) {
            int fechaTemp = lectorResultado.nextInt();
            String localTemp = lectorResultado.next();
            int golLocalTemp = lectorResultado.nextInt();
            int golVisitaTemp = lectorResultado.nextInt();
            String visitaTemp = lectorResultado.next();

            PartidoJugado partidoTemp = new PartidoJugado(fechaTemp, localTemp, golLocalTemp, golVisitaTemp, visitaTemp);
            campeonato.agregarPartido(partidoTemp);
        }
        lectorResultado.close();
        return campeonato;
    }
}
