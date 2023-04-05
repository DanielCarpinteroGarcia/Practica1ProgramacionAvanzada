package Algoritmos;

import PatronesDeDiseño.Distance;
import PatronesDeDiseño.EuclideanDistance;
import Rows.Row;
import Tables.Table;

import java.util.*;

public class KMeans implements Algorithm<Table, Integer, List<Double>>{

    private int numClusters;
    private int numIterations;
    private int seed;
    private List<Row> representantes;
    private Map<Row, List<Row>> grupos;

    private Distance distancia;

    public KMeans(){}

    public KMeans(int nc, int ni, int s, Distance d){
        this.numIterations = ni;
        this.seed = s;
        this.numClusters = nc;
        this.distancia = d;
    }

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
            for (int i = 0; i < numClusters; i++) {
                Random random = new Random(seed);
                Row representante = datos.getRowAt(random.nextInt(tam));
                representantes.add(representante);
            }
            for(int b = 0; b < datos.getRows().size(); b++){
                estimate(datos.getRowAt(b).getData());
            }
            centroide(datos);
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

    public void centroide(Table d){
        for(int i = 0; i < numIterations; i++){
            Iterator<List<Row>> it = grupos.values().iterator();
            int contador = 0;
            int j = 0;
            while(it.hasNext()){
                List<Row> l = it.next();
                double x = 0;
                double y = 0;
                double z = 0;
                for(Row r: l){
                    x += r.getData().get(0);
                    y += r.getData().get(1);
                    z += r.getData().get(2);
                    contador++;
                }
                List<Double> lista = new ArrayList<>(Arrays.asList(x/contador, y/contador, z/contador));
                this.representantes.set(j, new Row(lista));
                j++;
            }
            for(int k = 0; k < d.getRows().size(); k++){
                estimate(d.getRowAt(k).getData());
            }
        }
    }

    public double distancia(List<Double> l1, List<Double> l2){
        distancia = new EuclideanDistance();
        return distancia.calculateDistance(l1, l2);
    }

}
