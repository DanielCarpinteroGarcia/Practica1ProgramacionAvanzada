package LecturaCSV;

import Rows.Row;
import Rows.RowWithLabel;
import Tables.Table;
import Tables.TableWithLabels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSV {
    public static Table readTable(String nombreFichero) throws FileNotFoundException {
        List<String> headers = new ArrayList<>();
        List<Row> rows = new ArrayList<>();

        try {
            Scanner sc = new Scanner (new File(nombreFichero));
            String line = sc.nextLine();
            String[] campos = line.split(",");
            headers.addAll(Arrays.asList(campos));

            while(sc.hasNextLine()){
                List<Double> data = new ArrayList<>();
                line = sc.nextLine();
                campos = line.split(",");
                for(String c : campos) {
                    data.add(Double.valueOf(c));
                }
                rows.add(new Row(data));
            }
        } catch (FileNotFoundException e) {
            System.exit(0);
        }

        return new Table(headers,rows);
    }

    public static TableWithLabels readTableWithLabels(String nombreFichero) throws FileNotFoundException {
        List<String> headers = new ArrayList<>();
        List<Row> rows = new ArrayList<>();
        Map<String,Integer> labelsToIndex = new HashMap<>();

        try {
            Scanner sc = new Scanner (new File(nombreFichero));
            String line = sc.nextLine();
            String[] campos = line.split(",");
            headers.addAll(Arrays.asList(campos));

            while(sc.hasNextLine()){
                List<Double> data = new ArrayList<>();
                line = sc.nextLine();
                campos = line.split(",");
                for(int i = 0; i<campos.length-1; i++) {
                    data.add(Double.parseDouble(campos[i]));
                }


                String label = campos[campos.length - 1];
                int numberClass = labelsToIndex.size();
                if(!labelsToIndex.containsKey(label)) {
                    labelsToIndex.put(label,numberClass);
                }
                rows.add(new RowWithLabel(data,numberClass));

            }
        } catch (FileNotFoundException e) {
            System.exit(0);
        }

        return new TableWithLabels(headers,rows,labelsToIndex);

    }

}
