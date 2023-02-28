package LecturaDatosCSV;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> data = new ArrayList<>();
    public List<Double> getData(){
        return data;
    }

    public void setData(Double d){
        data.add(d);
    }
}
