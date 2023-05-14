package Mvc.vista;

import javafx.collections.ObservableList;

import java.io.IOException;

public interface InformaVista {

    Integer getNSongs();
    ObservableList<String> getListSongs() throws IOException;

    void listRecommendationsChanged();

}
