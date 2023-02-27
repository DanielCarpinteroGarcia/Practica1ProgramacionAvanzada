package LecturaDatosCSV;

import java.util.List;

public class Table {
    public List<String> headers;
    public List<Row> columnas;
    public Row getRowAt(int pos){
        return columnas.get(pos);
    }
}
