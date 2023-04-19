package LecturaCSV;

import Tables.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUnlabeledFileReader  extends ReaderTemplate {

    private Table table = new Table();
    private BufferedReader reader;

    public CSVUnlabeledFileReader(String source) {
        super(source);
    }
    @Override
    void openSource(String source) {
        try {
            reader = new BufferedReader(new FileReader(source));
        } catch(FileNotFoundException ex){
            System.exit(0);
        }
    }

    @Override
    void processHeaders(String headers) {
        String[] datas = headers.split(",");
        table.addHeaders(datas);
    }

    @Override
    void processData(String data) {
            List<Double> listData = new ArrayList<>();
            String[] datas = data.split(",");
            for(String c : datas) {
                listData.add(Double.valueOf(c));
            }
            table.addRow(listData);
    }

    @Override
    void closeSource() {
        if(reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @Override
    Table createTable() {
        return table;
    }

    @Override
    boolean hasMoreData() {
        try {
            return reader.ready();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    String getNextData() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
