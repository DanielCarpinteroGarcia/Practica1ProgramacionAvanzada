package Algoritmos;

import Rows.Row;
import Tables.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class KMeans {
    private int numClusters;
    private int numIterations;
    private long seed;

    public KMeans(int numClusters, int numIterations, long seed) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
    }

    public void train(Table datos) {
        Random random = new Random(seed);
        List<Row> representantes = new ArrayList<>();

        List<Integer> listIndex = new ArrayList<>();
        for(int i = 0; i<datos.getRows().size(); i++ ) {
            listIndex.add(i);
        }

        Collections.shuffle(listIndex,random);
        for(int i = 0; i<numClusters; i++) {
            representantes.add(datos.getRowAt(listIndex.get(i)));
        }

        for(int i = 0; i< numIterations; i++) {
            

        }
    }

    public Integer estimate(List<Double> dato) {
    return null;
    }

    private List<Row> representantes( Table datos ) {


    return null;
    }

}
