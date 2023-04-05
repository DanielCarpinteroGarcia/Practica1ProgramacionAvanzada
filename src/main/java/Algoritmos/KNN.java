package Algoritmos;

import PatronesDeDiseño.Distance;
import PatronesDeDiseño.DistanceClient;
import PatronesDeDiseño.EuclideanDistance;
import Rows.RowWithLabel;
import Tables.TableWithLabels;

import java.util.List;
import java.util.Random;

public class KNN  implements DistanceClient {
    private Distance distancia;
    private TableWithLabels table;

    public KNN(Distance d){
        this.distancia = d;
    }

    public void train(TableWithLabels data){
        this.table = data;
    }

    public Integer estimate (List<Double> data) {
        double menor = 1000000;
        int numberClass = -1;
        for(int i = 0; i < table.getRows().size(); i++){
            RowWithLabel row = table.getRowAt(i);
            List<Double> list = row.getData();
            double distancia = 0;
            distancia = distancia(list, data);
            if(distancia < menor){
                menor = distancia;
                numberClass = row.getNumberClass();
            }
        }
        return numberClass;
    }

    public double distancia(List<Double> list, List<Double> d){
        distancia = new EuclideanDistance();
        return distancia.calculateDistance(list, d);
    }

    @Override
    public void setDistance(Distance distance) {
        
    }
}
