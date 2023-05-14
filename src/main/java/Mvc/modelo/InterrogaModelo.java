package Mvc.modelo;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public interface InterrogaModelo {
    ObservableList<String> getSongs(String path) throws IOException;
    ObservableList<String> getListaRecomendaciones();
    Integer getNSongs();

    Integer getNumRecommendationsInicial();
}
