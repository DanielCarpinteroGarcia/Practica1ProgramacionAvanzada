package Mvc.modelo;

import Algoritmos.KMeansException;

public interface CambioModelo {

    void tipoDistancia(String distancia);
    void tipoAlgoritmo(String algortimo);

    void recommend(String song) throws KMeansException;
}
