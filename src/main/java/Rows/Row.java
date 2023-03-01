package Rows;
import java.util.ArrayList;
import java.util.List;

public class Row {
    public List<Double> data;

    public Row() {
        this.data = new ArrayList<>();
    }

    public Row(List<Double> data) {
        this.data = data;
    }

    public List<Double> getData(){
        return data;
    }
}


