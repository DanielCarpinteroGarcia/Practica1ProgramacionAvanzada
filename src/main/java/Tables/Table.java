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

    public List<Row> getRows() {
        return this.rows;
    }

    public List<Double> getData(int indexRow) {
        return this.rows.get(indexRow).getData();
    }

    public List<String> getHeaders() {
        return this.headers;
    }

    public void addHeaders(String[] list) {
        this.headers.addAll(Arrays.asList(list));
    }

    public void addRow(List<Double> data) {
        this.rows.add(new Row(data));
    }

    public int size() {
        return rows.size();
    }





}

