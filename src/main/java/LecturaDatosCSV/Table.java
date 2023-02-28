package LecturaDatosCSV;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
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

    public void setHeaders(List<String> l){
        headers = l;
    }

    public void setColumnas(Row r){
        columnas.add(r);
    }
}
