package LecturaCSV;

import Tables.Table;
import Tables.TableWithLabels;

import java.io.BufferedReader;
import java.io.IOException;

abstract class ReaderTemplate {
    protected String source;
    protected BufferedReader reader;

    public ReaderTemplate(String source) {
        this.source = source;
    }

    abstract void openSource(String source);
    abstract void processHeaders(String headers);
    abstract void processData(String data);
    abstract void closeSource();
    abstract Table createTable();
    boolean hasMoreData(BufferedReader data) throws IOException {
        return data.ready();
    }
    String getNextData(BufferedReader data) throws IOException {
        return data.readLine();
    }

    public final Table readTableFromSource() throws IOException {
        openSource(source);
        String headers = getNextData(reader);
        processHeaders(headers);
        while(hasMoreData(reader)) {
            String data = getNextData(reader);
            processData(data);
        }
        closeSource();

        return createTable();
    }
}
