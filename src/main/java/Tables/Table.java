package Tables;
import Rows.Row;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table(List<String> headers, List<Row> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    public Row getRowAt(int rowNumber){
        return rows.get(rowNumber);
    }

   public List<Row> getRows() {
        return this.rows;
   }

   public List<String> getHeaders() {
        return this.headers;
   }





}

