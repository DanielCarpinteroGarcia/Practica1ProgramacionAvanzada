package Mvc.modelo;

import Algoritmos.*;
import Distancias.Distance;
import Distancias.EuclideanDistance;
import Distancias.ManhattanDistance;
import LecturaCSV.CSV;
import Mvc.vista.InformaVista;
import Tables.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionModelo implements CambioModelo,InterrogaModelo {

    private InformaVista vista;
    private RecSys recSys;
    private CSV csv;
    private Algorithm algorithm;
    List<String> listaCanciones;

    List<String> listaRecomendaciones;

    private Table tableTrain;
    private Table tableTest;

    private Distance distance;


    public ImplementacionModelo(){
    }

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    @Override
    public void getSongs(String fileName) throws IOException {
        listaCanciones = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready()) {
            listaCanciones.add(reader.readLine());
        }
        ObservableList<String> listSongs = FXCollections.observableList(listaCanciones);
        vista.setListaCanciones(listSongs);
    }


    public void tipoDistancia(String distancia) {
        if(distancia.equals("euclidean")) {
            distance = new EuclideanDistance();
        } else {
            distance = new ManhattanDistance();
        }
    }

    public void tipoAlgoritmo(String algoritmo) {
       csv = new CSV();
        if(algoritmo.equals("knn")) {
            tableTrain = csv.readTableWithLabels("src/ficheros/songs_files/songs_train.csv");
            tableTest = csv.readTableWithLabels("src/ficheros/songs_files/songs_test.csv");
            algorithm = new KNN(distance);

        } else {
            tableTrain = csv.readTable("src/ficheros/songs_files/songs_train_withoutnames.csv");
            tableTest = csv.readTable("src/ficheros/songs_files/songs_test_withoutnames.csv");
            algorithm = new KMeans(15, 200, 4321,distance);
        }
    }

    public void recommend(String song) throws KMeansException {
        recSys = new RecSys(algorithm);
        recSys.train(tableTrain);
        recSys.run(tableTest,listaCanciones);
        listaRecomendaciones = recSys.recommend(song,5);
    }

    public List<String> getListaRecomendaciones() {
        return listaRecomendaciones;
    }


}
