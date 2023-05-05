package Mvc.controlador;

import Mvc.modelo.CambioModelo;
import Mvc.vista.InterrogaVista;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ImplementacionControlador implements Controlador {
    private InterrogaVista vista;

    private CambioModelo modelo;

    public ImplementacionControlador() {}
    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public void inicializarCanciones() throws IOException {
        modelo.loadSongs("src/ficheros/songs_files/songs_test_names.csv");
    }

    @Override
    public void tipoAlgoritmo(String algoritmo) {
        modelo.tipoAlgortimo(algoritmo);

    }

    public void tipoDistancia(String distancia) {
        modelo.tipoDistancia(distancia);
    }

    public void run() {
        modelo.run();
    }
}
