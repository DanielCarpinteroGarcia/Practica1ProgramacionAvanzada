package LecturaCSV;

import Rows.Row;
import Rows.RowWithLabel;
import Tables.Table;
import Tables.TableWithLabels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSV {
    public static Table readTable(String nombreFichero) {
       Table table = new Table();

        try {
            Scanner sc = new Scanner (new File(nombreFichero));
            String line = sc.nextLine();
            String[] campos = line.split(",");
            table.addHeaders(campos);

            while(sc.hasNextLine()){
                List<Double> data = new ArrayList<>();
                line = sc.nextLine();
                campos = line.split(",");
                for(String c : campos) {
                    data.add(Double.valueOf(c));
                }
                table.addRow(data);
            }
        } catch (FileNotFoundException e) {
            System.exit(0);
        }

        return table;
    }

    public static TableWithLabels readTableWithLabels(String nombreFichero) {
        TableWithLabels tableWithLabels = new TableWithLabels();

        try {
            Scanner sc = new Scanner (new File(nombreFichero));
            String line = sc.nextLine();
            String[] campos = line.split(",");
            tableWithLabels.addHeaders(campos);

            while(sc.hasNextLine()){
                List<Double> data = new ArrayList<>();
                line = sc.nextLine();
                campos = line.split(",");
                for(int i = 0; i<campos.length-1; i++) {
                    data.add(Double.parseDouble(campos[i]));
                }
                String label = campos[campos.length - 1];
                tableWithLabels.addRow(data,label);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        }
        return tableWithLabels;
    }

}
