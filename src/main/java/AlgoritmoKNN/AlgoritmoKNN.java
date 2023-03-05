package AlgoritmoKNN;

import LecturaDatosCSV.Row;
import LecturaDatosCSV.RowWithLabel;
import LecturaDatosCSV.TableWithLabels;

import java.util.List;

public class AlgoritmoKNN {
    private TableWithLabels t;
    public void train(TableWithLabels data){
        setT(data);
    }

    public Integer estimate(List<Double> data){
        TableWithLabels t = getT();
        double menor = 1000000;
        int clase = -1;
        for(int i = 0; i < t.getColumnas().size(); i++){
            RowWithLabel r = t.getRowAt(i);
            List<Double> l = r.getData();
            double dist = 0;
            for(int j = 0; j < l.size(); j++){
                dist += distancia(data.get(j), l.get(j));
            }
            if(dist < menor){
                menor = dist;
                clase = r.getNumberClass();
            }
        }
        return clase;
    }

    public double distancia(double n, double n2){
        return Math.sqrt(Math.pow(n - n2, 2));
    }

    public TableWithLabels getT(){
        return t;
    }

    public void setT (TableWithLabels table){
        t = table;
    }
}
