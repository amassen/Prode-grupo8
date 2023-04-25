import java.io.IOException;
import java.sql.*;

public class LeerResultado {
    public static Campeonato leerResultados() throws SQLException {
        //Path resultados = Paths.get("resultados.csv");
        //Scanner lectorResultado = new Scanner(resultados);
        //lectorResultado.useDelimiter("[;\\n\\r]+");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/resultados", "root","root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from resultados");

        Campeonato campeonato = new Campeonato();
        while (rs.next()) {
            int idTemp = rs.getInt("id");
            int fechaTemp = rs.getInt("fecha");
            String localTemp = rs.getString("equipoLocal");
            int golLocalTemp = rs.getInt("golesLocal");
            int golVisitaTemp = rs.getInt("golesVisitante");
            String visitaTemp = rs.getString("equipoVisitante");

            PartidoJugado partidoTemp = new PartidoJugado(fechaTemp, localTemp, golLocalTemp, golVisitaTemp, visitaTemp);
            campeonato.agregarPartido(partidoTemp);
        }
        rs.close();
        conn.close();
        return campeonato;
    }
}
