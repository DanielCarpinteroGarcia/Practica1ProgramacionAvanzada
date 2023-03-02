package Tables;

import Rows.Row;

import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{

    private Map<String,Integer> labelsToIndex;

    public TableWithLabels() {
        super();
    }

    public TableWithLabels(List<String> headers, List<Row> data, Map<String,Integer> labelsToIndex) {
        super(headers,data);
        this.labelsToIndex = labelsToIndex;
    }
}
