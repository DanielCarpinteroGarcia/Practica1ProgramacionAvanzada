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
            double distancia = 0;
            for(int j = 0; j < l.size(); j++){
                distancia += Math.sqrt(Math.pow(data.get(i) - l.get(i), 2));
            }
            if(distancia < menor){
                menor = distancia;
                clase = r.getNumberClass();
            }
        }
        return clase;
    }

    public double distancia(double n, double n2, ){

    }

    public TableWithLabels getT(){
        return t;
    }

    public void setT (TableWithLabels table){
        t = table;
    }
}
