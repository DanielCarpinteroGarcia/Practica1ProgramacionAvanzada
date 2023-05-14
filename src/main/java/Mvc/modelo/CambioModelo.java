package Mvc.modelo;

import Algoritmos.KMeansException;
import javafx.collections.ObservableList;

public interface CambioModelo {

    void tipoDistancia(String distancia);
    void tipoAlgoritmo(String algortimo);

    void recommendDinamico(String songSelected,Integer numRecommendations);

    void recommend(String songSelected);
}
