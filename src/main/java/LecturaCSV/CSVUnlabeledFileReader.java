package LecturaCSV;

import Rows.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVUnlabeledFileReader extends ReaderTemplate {

    private Scanner sc;

    public CSVUnlabeledFileReader(String f) {
        super(f);
    }

    @Override
    public void openSource(String source) {
        try {
            sc = new Scanner (new File(source));
        } catch (FileNotFoundException e) {
            System.exit(0);
        }
    }

    @Override
    public void processHeaders(String headers) {

    }

    @Override
    public void processData(String data) {

    }

    @Override
    public void closeSource() {
        sc.close();
    }

    @Override
    public boolean hasMoreData() {
        if(sc.hasNext())
            return true;
        return false;
    }

    @Override
    public String getNextData() {
        if(hasMoreData()){
            return sc.nextLine();
        }
        return null;
    }
}
