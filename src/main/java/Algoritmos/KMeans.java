package Algoritmos;

import Rows.Row;
import Tables.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans {
    private int numClusters;
    private int numIterations;
    private long seed;
    private List<Row> representantes;

    public KMeans(int numClusters, int numIterations, long seed, List<Row> representantes) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
        this.representantes = new ArrayList<>(numClusters);
    }

    public void train(Table datos) {
        Random random = new Random(seed);
        for(int i = 0; i<numClusters; i++) {
            representantes.add(datos.getRowAt(random.nextInt() * datos.getRows().size()));
        }

        int[] asignaciones;
        for(int i = 0; i< numIterations; i++) {

        }
    }

    public Integer estimate(List<Double> dato) {
    return null;
    }

    public int[] asignarGrupos(Table data) {
        int[] indiceGrupo = new int[data.getRows().size()];
        double menor = 1000000;
        for(int i = 0; i < data.getRows().size(); i++) {
            double distancia = 0;
            for(int j = 0; j < representantes.size(); j++){
                distancia += distancia(data.getRowAt(i).getData(),representantes.get(j).getData());
                if(distancia <= menor){
                    indiceGrupo[i] = j;
                }
            }
        }
        return indiceGrupo;
    }
    public double distancia(List<Double> list1, List<Double> list2){
        double resultado = 0.0;
        for(int i = 0; i<list1.size();i++) {
            resultado += Math.pow(list1.get(i) - list2.get(i),2);
        }
        return Math.sqrt(resultado);
    }


}



