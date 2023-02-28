package LecturaDatosCSV;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @org.junit.jupiter.api.Test
    void readTable() throws FileNotFoundException {
        CSV objeto = new CSV();
        String fichero = "miles_dollars.csv";
        String fichero2 = "iris.csv";
        Table obtenido = objeto.readTable(fichero);

        System.out.print("Número de ejemplares o filas leídos");
        assertEquals(25, obtenido.columnas.size());

        System.out.print("Número de columnas leído");
        int nColumnas = 0;
        for(Row r: obtenido.columnas){
            nColumnas += r.data.size();
        }
        assertEquals(50, nColumnas);

        System.out.print("Nombre de las etiquetas de las cabeceras");
        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        assertEquals(l, obtenido.headers);

        System.out.print("Recuperar contenidos de las tablas guardadas.");
        List<Double> lista = new ArrayList<>();
        lista.add();
        lista.add();
        assertEquals();
    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() {
    }
}