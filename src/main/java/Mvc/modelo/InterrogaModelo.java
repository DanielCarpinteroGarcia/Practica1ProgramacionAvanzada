package Mvc.modelo;

import javafx.collections.ObservableList;

import java.io.IOException;

public interface InterrogaModelo {
    public ObservableList<String> getSongs(String path) throws IOException;

    ObservableList<Integer> getNSongs();


    ObservableList<String> recommend();
}
