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
            t.setHeaders(e);
        }

        while(entrada.hasNextLine()){
            r = new Row();
            linea = entrada.nextLine();
            cadena = linea.split(",");
            for(String e : cadena){
                r.setData(Double.parseDouble(e));
            }
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
        for(String e : cadena){
            t.setHeaders(e);
        }

        int c = 0;
        while(entrada.hasNextLine()){
            r = new RowWithLabel();
            linea = entrada.nextLine();
            cadena = linea.split(",");
            int i;
            for(i = 0; i < cadena.length - 1; i++){
                r.setData(Double.parseDouble(cadena[i]));
            }
            r.setNumberClass(c);
            t.setColumnas(r);
            if(!t.getLabelsToIndex().containsKey(cadena[i])){
                c++;
                t.setLabelsToIndex(cadena[i], c);
            }
        }
        return t;
    }
}
