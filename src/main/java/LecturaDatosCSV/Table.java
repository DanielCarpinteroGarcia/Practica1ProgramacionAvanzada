package LecturaDatosCSV;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public List<String> headers = new ArrayList<>();
    public List<Row> columnas = new ArrayList<>();
    public Row getRowAt(int pos){
        return columnas.get(pos);
    }
}
