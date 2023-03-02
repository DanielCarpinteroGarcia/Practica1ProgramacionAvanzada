package LecturaCSV;

import Rows.Row;
import Tables.Table;
import Tables.TableWithLabels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        List<String> headers = new ArrayList<>();
        List<Row> data = new ArrayList<>();
        Map<String,Integer> labelsToIndex = new HashMap<>();

        try {
            Scanner sc = new Scanner (new File(nombreFichero));
            String line = sc.nextLine();
            String[] campos = line.split(",");
            headers.addAll(Arrays.asList(campos));

            while(sc.hasNextLine()){
                List<Double> list = new ArrayList<>();
                line = sc.nextLine();
                campos = line.split(",");
                for(String c : campos) {
                    list.add(Double.valueOf(c));
                }
                labelsToIndex.put(campos[campos.length-1],labelsToIndex.size());
                Row row = new Row(list);
                data.add(row);
            }
        } catch (FileNotFoundException e) {
            System.exit(0);
        }

        return new TableWithLabels(headers,data,labelsToIndex);
    }

}
