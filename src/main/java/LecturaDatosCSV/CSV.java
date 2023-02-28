package LecturaDatosCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV {
    public Table readTable(String fichero) throws FileNotFoundException {
        Table t = new Table();
        Row r;
        Scanner entrada = new Scanner(new File(fichero));
        String linea = entrada.nextLine();
        String [] cadena = linea.split(",");
        List<String> lista = new ArrayList<>();
        for(String e : cadena){
            lista.add(e);
        }
        t.setHeaders(lista);

        while(entrada.hasNextLine()){
            r = new Row();
            List<Double> l = new ArrayList<>();
            linea = entrada.nextLine();
            cadena = linea.split(",");
            for(String e : cadena){
                l.add(Double.parseDouble(e));
            }
            r.setData(l);
            t.setColumnas(r);
        }
        entrada.close();
        return t;
    }

    public TableWithLabels readTableWithLabels(String fichero) throws FileNotFoundException {
        TableWithLabels t = new TableWithLabels();
        RowWithLabel r;
        Scanner entrada = new Scanner(new File(fichero));
        String linea = entrada.nextLine();
        String [] cadena = linea.split(",");
        List<String> lista = new ArrayList<>();
        for(String e : cadena){
            lista.add(e);
        }
        t.setHeaders(lista);

        while(entrada.hasNextLine()){
            r = new RowWithLabel();
            linea = entrada.nextLine();
            cadena = linea.split(",");
            int i;
            List<Double> l = new ArrayList<>();
            for(i = 0; i < cadena.length - 1; i++){
                l.add(Double.parseDouble(cadena[i]));
            }
            r.setData(l);
            r.setNumberClass(t.getLabelsToIndex().size());
            t.setColumnas(r);
            t.setLabelsToIndex(cadena[i], r.getNumberClass());
        }
        return t;
    }
}
