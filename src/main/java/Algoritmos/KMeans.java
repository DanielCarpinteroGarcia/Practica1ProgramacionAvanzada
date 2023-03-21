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

        for(int i = 0; i<numClusters; i++) {
            representantes.add(datos.getRowAt(random.nextInt() * datos.getRows().size()));
        }

        for(int i = 0; i< numIterations; i++) {

        }
    }

    public Integer estimate(List<Double> dato) {
    return null;
    }


}
