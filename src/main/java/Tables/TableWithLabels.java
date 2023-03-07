package Tables;

import Rows.Row;
import Rows.RowWithLabel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String,Integer> labelsToIndex;

    public TableWithLabels(List<String> headers, List<Row> rows, Map<String,Integer> labelsToIndex) {
        super(headers,rows);
        this.labelsToIndex = labelsToIndex;

    }

    @Override
    public RowWithLabel getRowAt(int rowNumber) {
        return (RowWithLabel) super.getRowAt(rowNumber);
    }

    public Map<String,Integer> getLabelsToIndex() {
        return this.labelsToIndex;
    }

}
