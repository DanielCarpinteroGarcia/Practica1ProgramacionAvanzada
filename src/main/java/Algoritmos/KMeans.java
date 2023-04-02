package Algoritmos;

import Rows.Row;
import Tables.Table;

import java.util.*;

public class KMeans implements Algorithm<Table, Integer, List<Double>>{

    private int numClusters;
    private int numIterations;
    private int seed;
    private List<Row> representantes;
    private Map<Row, List<Row>> grupos;

    public KMeans(){}

    public KMeans(int nc, int ni, int s){
        numClusters = nc;
        numIterations = ni;
        seed = s;
    }

    public int getNumClusters(){
        return numClusters;
    }

    public int getNumIterations(){
        return numIterations;
    }

    public void setRepresentantes(List<Row> representantes) {
        this.representantes = representantes;
    }

    @Override
    public Integer estimate(List<Double> dato){
        return asignar_grupo(dato);
    }

    @Override
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
            //calcular_centroide();
        }
    }

    public int asignar_grupo(List<Double> d){
        grupos = new HashMap<>();
        double menor = 100000000;
        double distancia = 0;
        int r = -1;
        for(int i = 0; i < representantes.size(); i++){
            distancia = distancia(d, representantes.get(i).getData());
            if(distancia < menor){
                menor = distancia;
                r = i;
            }
        }
        List<Row> lista = new ArrayList<>();
        Row nuevo = new Row(d);
        lista.add(nuevo);
        if(!grupos.containsKey(representantes.get(r))){
            grupos.put(representantes.get(r), lista);
        } else {
            lista = grupos.get(representantes.get(r));
            lista.add(nuevo);
            grupos.put(representantes.get(r), lista);
        }
        return r;
    }

    public void calcular_centroide(){
    }

    public double distancia(List<Double> l1, List<Double> l2){
        int resul = 0;
        for(int i = 0; i < l1.size(); i++){
            resul += Math.pow(l1.get(i) - l2.get(i),2);
        }
        return Math.sqrt(resul);
    }

}
