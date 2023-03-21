package Tables;
import Rows.Row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table() {
        this.headers = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public Row getRowAt(int rowNumber){
        return rows.get(rowNumber);
    }

    public void addHeaders(String[] list) {
        this.headers.addAll(Arrays.asList(list));
    }

    public void addRow(List<Double> data) {
        this.rows.add(new Row(data));
    }





}

