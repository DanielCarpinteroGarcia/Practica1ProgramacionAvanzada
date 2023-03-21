package Algoritmos;

import Rows.RowWithLabel;
import Tables.TableWithLabels;

import java.util.List;
import java.util.Random;

public class KNN {

    private TableWithLabels table;

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
            for(int j = 0; j < list.size(); j++){
                distancia += distancia(data.get(j), list.get(j));
            }
            distancia = Math.sqrt(distancia);
            if(distancia < menor){
                menor = distancia;
                numberClass = row.getNumberClass();
            }
        }
        return numberClass;
    }

    public double distancia(double num1, double num2){
        return (Math.pow(num1 - num2, 2));
    }

}
