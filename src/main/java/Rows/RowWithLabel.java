package Rows;

import java.util.List;
import java.util.Map;

public class RowWithLabel extends Row {
    private int numberClass;
    public RowWithLabel(List<Double> data, int numberClass) {
        super(data);
        this.numberClass = numberClass;
    }

    public int getNumberClass() {
        return this.numberClass;
    }
}
