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
            for(i = 0; i < cadena.length - 1; i++){
                r.data.add(Double.parseDouble(cadena[i]));
            }
            r.numberClass = t.labelsToIndex.size();
            t.columnas.add(r);
            t.labelsToIndex.put(cadena[i], r.numberClass);
        }
        return t;
    }
}
