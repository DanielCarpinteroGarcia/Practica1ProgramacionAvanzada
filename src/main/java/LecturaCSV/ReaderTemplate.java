package LecturaCSV;

import Tables.Table;
import Tables.TableWithLabels;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class ReaderTemplate {
    protected String source;

    public ReaderTemplate(String source) {
        this.source = source;
    }

    abstract void openSource(String source);
    abstract void processHeaders(String headers);
    abstract void processData(String data);
    abstract void closeSource();
    abstract Table createTable();
    abstract boolean hasMoreData();
    abstract String getNextData();

    public final Table readTableFromSource() throws IOException {
        openSource(source);
        String headers = getNextData();
        processHeaders(headers);
        while(hasMoreData()) {
            String data = getNextData();
            processData(data);
        }
        closeSource();

        return createTable();
    }
}
