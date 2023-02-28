package LecturaDatosCSV;

import java.util.HashMap;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String, Integer> labelsToIndex = new HashMap<>();
    public RowWithLabel getRowAt(int pos){
        return (RowWithLabel) getColumnas().get(pos);
    }

    public Map<String, Integer> getLabelsToIndex(){
        return labelsToIndex;
    }

    public void setLabelsToIndex(String e, int n){
        labelsToIndex.put(e, n);
    }
}
