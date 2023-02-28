package LecturaDatosCSV;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers = new ArrayList<>();
    private List<Row> columnas = new ArrayList<>();
    public Row getRowAt(int pos){
        return columnas.get(pos);
    }

    public List<String> getheaders(){
        return headers;
    }

    public List<Row> getColumnas(){
        return columnas;
    }

    public void setHeaders(String h){
        headers.add(h);
    }

    public void setColumnas(Row r){
        columnas.add(r);
    }
}
