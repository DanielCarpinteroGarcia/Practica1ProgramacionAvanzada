package Mvc.modelo;

import Algoritmos.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementacionModelo implements CambioModelo,InterrogaModelo {

    Map<String,Algorithm> algorithms = new HashMap<>();
    Map<String, Table> tables = new HashMap<>();
    Map<String,String> filenames = new HashMap<>();
    private InformaVista vista;
    private RecSys recSys;
    private CSV csv;
    private KNN knn;
    private KMeans kMeans;
    List<String> listaCanciones;

    List<String> listaRecomendaciones;

    Integer numRecommendations = 5;



    public void filenames() {
        String ruta = "src/ficheros/songs_files";
        String sep = System.getProperty("file.separator");

        filenames.put("knn"+"train",ruta+sep+ "songs_train.csv");
        filenames.put("knn"+"test",ruta+sep+ "songs_test.csv");
        filenames.put("kmeans"+"train",ruta+sep+ "songs_train_withoutnames.csv");
        filenames.put("kmeans"+"test",ruta+sep+ "songs_test_withoutnames.csv");
    }


    public ImplementacionModelo(){
    }

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    @Override
    public ObservableList<String> getSongs(String fileName) throws IOException {
        listaCanciones = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready()) {
            listaCanciones.add(reader.readLine());
        }
        ObservableList<String> listSongs = FXCollections.observableList(listaCanciones);
        return listSongs;
    }

    public ObservableList<Integer> getNSongs() {
       List<Integer> listaNCanciones = new ArrayList<>();
       for( int i = 0; i < listaCanciones.size() - 1; i++) {
           listaNCanciones.add( i+1);
       }
        ObservableList<Integer> listNSongs = FXCollections.observableList(listaNCanciones);

       return listNSongs;

    }

    public void tipoAlgoritmo(String algoritmo) {
        filenames();
        csv = new CSV();
        if(algoritmo.equals("knn")) {
            tables.put("tableTrain" , csv.readTableWithLabels(filenames.get(algoritmo+"train")));
            tables.put("tableTest",csv.readTableWithLabels(filenames.get(algoritmo+"test")));
            knn = new KNN();
            algorithms.put("algorithm", knn);

        } else {
            tables.put("tableTrain" , csv.readTable(filenames.get(algoritmo+"train")));
            tables.put("tableTest",csv.readTable(filenames.get(algoritmo+"test")));
            kMeans = new KMeans(15, 200, 4321, new EuclideanDistance());
            algorithms.put("algorithm", kMeans);
        }
    }

    public void tipoDistancia(String distancia) {
        if(distancia.equals("euclidean") && knn != null) {
            knn.setDistance(new EuclideanDistance());
        } else if(distancia.equals("euclidean") && kMeans != null) {
           kMeans.setDistance(new EuclideanDistance());
        } else if(distancia.equals("manhattan") && knn != null ) {
            knn.setDistance(new ManhattanDistance());
        } else {
            kMeans.setDistance(new ManhattanDistance());
        }
    }




    public ObservableList<String> recommend() {
        String songSelected = vista.getSongSelected();
        recSys = new RecSys(algorithms.get("algorithm"));
        try {
            recSys.train(tables.get("tableTrain"));
        } catch (KMeansException e) {
            throw new RuntimeException(e);
        }
        recSys.run(tables.get("tableTest"),listaCanciones);
        listaRecomendaciones = recSys.recommend(songSelected,numRecommendations);
        ObservableList<String> listRecommendations = FXCollections.observableList(listaRecomendaciones);

        return listRecommendations;

    }



}
