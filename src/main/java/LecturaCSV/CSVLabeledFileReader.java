package LecturaCSV;

import Tables.Table;
import Tables.TableWithLabels;

import java.util.ArrayList;
import java.util.List;

public class CSVLabeledFileReader extends CSVUnlabeledFileReader {

    TableWithLabels table = new TableWithLabels();
    public CSVLabeledFileReader(String source) {
        super(source);
    }

    void processData(String data) {
        List<Double> listData = new ArrayList<>();
       String[] datas = data.split(",");
        for(int i = 0; i<datas.length-1; i++) {
            listData.add(Double.parseDouble(datas[i]));
        }
        String label = datas[datas.length - 1];
        table.addRow(listData,label);
    }

    TableWithLabels createTable() {
        return table;
    }
}
