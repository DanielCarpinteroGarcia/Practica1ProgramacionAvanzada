package Algoritmos;

import Rows.Row;
import Tables.Table;

import java.util.*;

public class KMeans {
    private int numClusters;
    private int numIterations;
    private long seed;
    private List<Row> representantes = new ArrayList<>();

    public KMeans(int numClusters, int numIterations, long seed) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
    }

    public void train(Table datos) {
        Random random = new Random(seed);
        for(int i = 0; i<numClusters; i++) {
            representantes.add(datos.getRowAt(random.nextInt() * datos.getRows().size()));
        }

        Integer[] asignacionesGrupos = new Integer[datos.getRows().size()];
        for(int i = 0; i< numIterations; i++) {
            for(int j = 0; j<datos.getRows().size(); j++) {
                asignacionesGrupos[j] = asignarGrupo(datos.getData(j));
            }
            calculoCentroide(asignacionesGrupos,datos);
        }
    }

    public Integer estimate(List<Double> dato) {
        return asignarGrupo(dato);
    }

    public Integer asignarGrupo(List<Double> dato) {
        Integer rep = 0;
        double menor = distancia(dato,representantes.get(0).getData());

        double distancia = 0;
        for(int i = 0; i < representantes.size(); i++){
            distancia = distancia(dato,representantes.get(i).getData());
            if(distancia <= menor){
                menor = distancia;
                rep = i;
            }
        }
        return rep;
    }

    public void calculoCentroide(Integer[] asignacionGrupos, Table datos) {
        Map<Integer,Double> centroides = new HashMap<>();
        for( int i = 0; i < representantes.size(); i++) {
            centroides.put(i,0.0);
        }
        for( int i = 0; i < asignacionGrupos.length; i++) {
            int grupo = asignacionGrupos[i];

            


        }




    }
    public double distancia(List<Double> list1, List<Double> list2){
        double resultado = 0.0;
        for(int i = 0; i<list1.size();i++) {
            resultado += Math.pow(list1.get(i) - list2.get(i),2);
        }
        return Math.sqrt(resultado);
    }


}



