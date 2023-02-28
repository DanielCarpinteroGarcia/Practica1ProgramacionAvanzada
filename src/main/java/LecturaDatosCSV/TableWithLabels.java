package LecturaDatosCSV;

import java.util.Map;

public class TableWithLabels extends Table{
    public Map<String, Integer> labelsToIndex;
    public RowWithLabel getRowAt(int pos){
        return (RowWithLabel) columnas.get(pos);
    }
}
