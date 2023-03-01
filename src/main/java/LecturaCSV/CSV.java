package LecturaCSV;

import Rows.Row;
import Tables.Table;
import Tables.TableWithLabels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV {

    public static Table readTable(String nombreFichero) throws FileNotFoundException {
        List<String> headers = new ArrayList<>();
        List<Row> data = new ArrayList<>();

        try {
            Scanner sc = new Scanner (new File(nombreFichero));
            String line = sc.nextLine();
            String[] campos = line.split(",");
            for(String header : campos) {
                headers.add(header);
            }

            while(sc.hasNextLine()){
                List<Double> list = new ArrayList<>();
                line = sc.nextLine();
                campos = line.split(",");
                for(String c : campos) {
                    list.add(Double.valueOf(c));
                }
                Row row = new Row(list);
                data.add(row);
            }
        } catch (FileNotFoundException e) {
            System.exit(0);
        }

        return new Table(headers,data);
    }

    public static TableWithLabels readTableWithLabels(String nombreFichero) throws FileNotFoundException {
        
    }

}
