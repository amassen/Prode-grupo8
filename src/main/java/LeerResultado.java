import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

public class LeerResultado {
    public static Campeonato leerResultados() throws IOException, SQLException {
        //Path resultados = Paths.get("resultados.csv");
        //Scanner lectorResultado = new Scanner(resultados);
        //lectorResultado.useDelimiter("[;\\n\\r]+");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/resultados", "root","Lilc1982");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from resultados");

        Campeonato campeonato = new Campeonato();
        while (rs.next()) {
            int idTemp = rs.getInt("id");
            int fechaTemp = rs.getInt("fecha");
            String localTemp = rs.getString("equipolocal");
            int golLocalTemp = rs.getInt("goleslocal");
            int golVisitaTemp = rs.getInt("golesvisitante");
            String visitaTemp = rs.getString("equipovisitante");

            PartidoJugado partidoTemp = new PartidoJugado(fechaTemp, localTemp, golLocalTemp, golVisitaTemp, visitaTemp);
            campeonato.agregarPartido(partidoTemp);
        }
        rs.close();
        conn.close();
        return campeonato;
    }
}
