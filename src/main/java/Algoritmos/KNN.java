package Algoritmos;

import Rows.RowWithLabel;
import Tables.TableWithLabels;

import java.util.List;

public class KNN {

    private TableWithLabels table;

    public void train(TableWithLabels data){
        this.table = data;
    }

    public Integer estimate (List<Double> data) {
        double menor = 1000000;
        int numberClass = -1;
        for(int i = 0; i < table.getRows().size(); i++){
            double distancia = 0.0;
            for(int j = 0; j < data.size(); j++){
                distancia += distancia(table.getRowAt(i).getData(),data);
            }
            if(distancia <= menor){
                menor = distancia;
                numberClass = table.getRowAt(i).getNumberClass();
            }
        }
        return numberClass;
    }

    public double distancia(List<Double> list1, List<Double> list2){
        double resultado = 0.0;
        for(int i = 0; i<list1.size();i++) {
            resultado += Math.pow(list1.get(i) - list2.get(i),2);
        }
        return Math.sqrt(resultado);
    }

}
