import java.util.ArrayList;

public class Pronostico {
    private ArrayList<PartidoPronosticado> pronosticosArray;
    private ArrayList<PartidoJugado> resultadosArray;

    public Pronostico(ArrayList<PartidoPronosticado> pronosticosArray, ArrayList<PartidoJugado> resultadosArray) {
        this.pronosticosArray = pronosticosArray;
        this.resultadosArray = resultadosArray;
    }


    public int puntosObtenidos(){
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



        return 0;
    }

    public ArrayList<PartidoJugado> getResultadosArray() {
        return resultadosArray;
    }

    public ArrayList<PartidoPronosticado> getPronosticosArray() {
        return pronosticosArray;
    }
}
