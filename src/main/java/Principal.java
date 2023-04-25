import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal {
    public static void main(String[] args) throws IOException, SQLException {

        ArrayList<PartidoPronosticado> pronosticosArray = LeerPronostico.leerPronosticos();
        System.out.println("Pronosticos");
        for (PartidoPronosticado partidoPronosticado : pronosticosArray) {
           partidoPronosticado.mostrarPartidoPronosticado();
        }
        System.out.println("Resultados");
        Campeonato campeonato =  LeerResultado.leerResultados();
        for (PartidoJugado partidoJugado : campeonato.getPartidos()){
            partidoJugado.mostrarPartidoJugado();
        }

        HashMap<String, Jugador> jugadores = obtenerJugadores(pronosticosArray);
        Prode prode = new Prode(campeonato, jugadores);

        System.out.println("El campeonato tiene " + campeonato.cantFechas() + " fechas");

        Jugador jugador = prode.ganador();
        System.out.println("\uD83C\uDFC6 Ha ganado: " + jugador.getNombre() + " \uD83C\uDFC6");
    }

    private static HashMap<String, Jugador> obtenerJugadores(ArrayList<PartidoPronosticado> partidosPronosticados) {
        HashMap<String, Jugador> jugadores = new HashMap<>();

        for (PartidoPronosticado partido : partidosPronosticados) {
            Jugador jugador = jugadores.get(partido.getNombreJugador());
            if (jugador == null) {
                jugador = new Jugador(partido.getNombreJugador());
                jugadores.put(partido.getNombreJugador(), jugador);
            }
            jugador.agregarPartido(partido);
        }
        return jugadores;
    }

}

