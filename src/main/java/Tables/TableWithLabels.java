package Tables;

import Rows.RowWithLabel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String,Integer> labelsToIndex;

    public TableWithLabels() {
        super();
        this.labelsToIndex = new HashMap<>();
    }

    @Override
    public RowWithLabel getRowAt(int rowNumber) {
        return (RowWithLabel) super.getRowAt(rowNumber);
    }

    public void addRow(List<Double> data,String label) {
        int numberClass = this.labelsToIndex.size();
        if(!this.labelsToIndex.containsKey(label)) {
            this.labelsToIndex.put(label,numberClass);
        }
        this.getRows().add(new RowWithLabel(data,labelsToIndex.get(label)));
    }

}
