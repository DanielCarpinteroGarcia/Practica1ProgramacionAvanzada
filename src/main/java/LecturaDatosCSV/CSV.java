package LecturaDatosCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {
    public Table readTable(String fichero) throws FileNotFoundException {
        Table t = new Table();
        Row r;
        Scanner entrada = new Scanner(new File(fichero));
        String linea = entrada.nextLine();
        String [] cadena = linea.split(",");
        for(String e : cadena){
            t.headers.add(e);
        }

        while(entrada.hasNextLine()){
            r = new Row();
            linea = entrada.nextLine();
            cadena = linea.split(",");
            for(String e : cadena){
                r.data.add(Double.parseDouble(e));
            }
            t.columnas.add(r);
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
        for(String e : cadena){
            t.headers.add(e);
        }
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
