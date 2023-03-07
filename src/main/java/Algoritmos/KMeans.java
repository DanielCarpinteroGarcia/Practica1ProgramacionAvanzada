package Algoritmos;

import Tables.Table;
import Tables.TableWithLabels;

import java.util.List;
import java.util.Random;

public class KMeans {

    private int numClusters;
    private int numIterations;
    private int seed;

    public KMeans(int numClusters, int numIterations, long seed){
        numClusters = numClusters;
        numIterations = numIterations;
        seed = seed;
    }


    public Integer estimate(List<Double> dato){
        return null;
    }

    public void train(Table datos){
        Random random = new Random(seed);
        int representante = random.nextInt(datos.getRows().size());

    }

}
