package Rows;

import java.util.List;

public class RowWithLabels extends Row {
    private String label;

    public RowWithLabels() {
        super();
        label = null;
    }
    public RowWithLabels(List<Double> data, String label) {
        super(data);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
