package Algoritmos;

import Rows.Row;
import Rows.RowWithLabel;
import Tables.Table;
import Tables.TableWithLabels;

import java.util.*;

public class KMeans {

    private int numClusters;
    private int numIterations;
    private int seed;
    private List<Row> representantes;

    public KMeans(int nc, int ni, int s){
        numClusters = nc;
        numIterations = ni;
        seed = s;
    }

    public Integer estimate(List<Double> dato){
        return asignar_grupo(dato);
    }

    public void train(Table datos){
        representantes = new ArrayList<>();
        int tam = datos.getRows().size();
        for(int j = 0; j < numIterations; j++) {
            for (int i = 0; i < numClusters; i++) {
                Random random = new Random(seed);
                Row representante = datos.getRowAt(random.nextInt(tam));
                representantes.add(representante);
            }
            for(int b = 0; b < datos.getRows().size(); b++){
                estimate(datos.getRowAt(b).getData());
            }
        }
    }

    public int asignar_grupo(List<Double> d){
        Map<Row, List<Row>> grupos = new HashMap<>();
        int menor = 100000000;
        for(int i = 0; i < representantes.size(); i++){

        }
    }

    public double distancia(Row row1, Row row2){
        int resul = 0;
        for(int i = 0; i < row1.getData().size(); i++){
            resul += Math.pow(row1.getData().get(i) - row2.getData().get(i),2);
        }
        return Math.sqrt(resul);
    }


}
