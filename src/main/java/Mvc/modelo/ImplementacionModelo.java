package Mvc.modelo;

import Algoritmos.Algorithm;
import Algoritmos.KMeans;
import Algoritmos.KNN;
import Algoritmos.RecSys;
import Distancias.Distance;
import Distancias.EuclideanDistance;
import Distancias.ManhattanDistance;
import LecturaCSV.CSV;
import Mvc.vista.InformaVista;
import Tables.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionModelo implements CambioModelo,InterrogaModelo {

    private InformaVista vista;
    private List<String> listaCanciones;
    private RecSys recSys;

    private KNN knn;

    private KMeans kMeans;


    public ImplementacionModelo(){
    }

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    @Override
    public void loadSongs(String fileName) throws IOException {
        listaCanciones = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready()) {
            listaCanciones.add(reader.readLine());
        }
        ObservableList<String> listSongs = FXCollections.observableList(listaCanciones);
        vista.setListaCanciones(listSongs);
    }

    public void tipoAlgortimo(String algoritmo) {
        if( algoritmo.equals("knn")) {
            knn = new KNN();
            recSys = new RecSys(knn);
        } else {
            kMeans = new KMeans(15, 200, 4321, new EuclideanDistance());
            recSys = new RecSys(kMeans);
        }
    }

    public void tipoDistancia(String distancia) {
        if(distancia.equals("euclidean")) {
            knn.setDistance(new EuclideanDistance());
            kMeans.setDistance(new EuclideanDistance());
        } else {
            knn.setDistance(new ManhattanDistance());
            kMeans.setDistance(new ManhattanDistance());
        }
    }

    public void run() {
        CSV csv = new CSV();

        recSys.run();
    }





}
