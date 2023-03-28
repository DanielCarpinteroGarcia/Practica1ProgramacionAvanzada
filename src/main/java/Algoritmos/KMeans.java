package Algoritmos;

import Rows.Row;
import Rows.RowWithLabel;
import Tables.Table;
import Tables.TableWithLabels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans {

    private int numClusters;
    private int numIterations;
    private int seed;
    private List<Row> representantes;

    public KMeans(int nc, int ni, int s, List<Row> r){
        numClusters = nc;
        numIterations = ni;
        seed = s;
        representantes = r;
    }

    public Integer estimate(List<Double> dato){

    }

    public void train(Table datos){
        List<Row> representantes = new ArrayList<>();
        int tam = datos.getRows().size();
        for(int i = 0; i < 3; i++){
            Random random = new Random(seed);
            Row representante = datos.getRowAt(random.nextInt(tam));
            representantes.add(representante);
        }
    }

    public int asignar_grupo(Table d){
        double distancia;
        for(int i = 0; i < d.getRows().size(); i++){
            Row r1 = d.getRowAt(i);
            for(int j = 0; j < representantes.size(); j++){
                Row r2 = representantes.get(j);
                distancia = distancia();
            }
        }
    }

    public double distancia(Row row1, Row row2){
        
    }


}
