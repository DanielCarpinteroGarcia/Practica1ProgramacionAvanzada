package Algoritmos;

import Distancias.Distance;
import Distancias.DistanceClient;
import Distancias.EuclideanDistance;
import Rows.RowWithLabel;
import Tables.TableWithLabels;

import java.util.List;

public class KNN implements DistanceClient, Algorithm<TableWithLabels,Integer,List<Double>> {

    private TableWithLabels table;
    private Distance distancia;

    public KNN() {
        this.distancia = new EuclideanDistance();
    }
    public KNN(Distance distance) {
        this.distancia = distance;
    }

    public void train(TableWithLabels data){
        this.table = data;
    }



    public Integer estimate (List<Double> data) {
        double menor = distancia.calculateDistance(table.getRowAt(0).getData(),data);
        int numberClass = table.getRowAt(0).getNumberClass();

        for(int i = 0; i < table.getRows().size(); i++){
            double distance = distancia.calculateDistance(table.getRowAt(i).getData(),data);
            if(distance < menor){
                menor = distance;
                numberClass = table.getRowAt(i).getNumberClass();
            }
        }
        return numberClass;
    }


    @Override
    public void setDistance(Distance distance) {
        this.distancia = distance;
    }
}
