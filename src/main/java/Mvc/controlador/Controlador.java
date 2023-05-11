package Mvc.controlador;

import Algoritmos.KMeansException;

import java.io.IOException;

public interface Controlador {
    void tipoDistancia(String distancia);
    void tipoAlgoritmo(String algortimo);

    void recommend(String song) throws KMeansException;
}
