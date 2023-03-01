package Tables;
import Rows.Row;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> data;

    public Table() {
        this.headers = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    public Table(List<String> headers, List<Row> data) {
        this.headers = headers;
        this.data = data;
    }

    public Row getRowAt(int rowNumber){
        return null;
    }

    public List<String> getHeaders() {
        return this.headers;
    }

}

