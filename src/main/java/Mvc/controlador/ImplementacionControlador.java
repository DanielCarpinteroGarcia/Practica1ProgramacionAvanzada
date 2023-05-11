package Mvc.controlador;

import Algoritmos.KMeansException;
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


    public void tipoDistancia(String distancia) {
        modelo.tipoDistancia(distancia);
    }

    public void tipoAlgoritmo(String algoritmo) {
        modelo.tipoAlgoritmo(algoritmo);
    }
    public void recommend(String cancion) throws KMeansException {
        String song = (vista.getCancion());
        modelo.recommend(song);
    }



}
