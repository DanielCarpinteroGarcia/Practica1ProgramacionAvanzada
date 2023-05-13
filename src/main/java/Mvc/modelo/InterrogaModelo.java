package Mvc.modelo;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public interface InterrogaModelo {
    public ObservableList<String> getSongs(String path) throws IOException;

    Integer getNSongs();

    List<String> getListaRecomendaciones();

}
