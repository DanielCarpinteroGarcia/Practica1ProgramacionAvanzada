package Tests;

import LecturaCSV.CSV;
import Rows.Row;
import Tables.Table;
import Tables.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @Test
    void readTable() {
        CSV objeto = new CSV();
        String fichero = "src/ficheros/miles_dollars.csv";
        Table obtenido = objeto.readTable(fichero);

        assertEquals(25, obtenido.getRows().size());
        assertEquals(2, obtenido.getHeaders().size());

        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        assertEquals(l, obtenido.getHeaders());

        List<Double> resul = new ArrayList<>();
        resul.add(1211.0);
        resul.add(1802.0);
        List<Double> obt = obtenido.getRowAt(0).getData();
        assertEquals(resul, obt);

        //En este método no se comprueba si el número que se le asigna a cada fila es correcto ya que no guarda números de fila.
    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() {
        //Aquí solo comprobamos si el número que se asigna a cada fila es correcto,
        // el resto de comprobaciones ya están realizadas en el primer test.
        CSV objeto = new CSV();
        String fichero2 = "iris.csv";
        TableWithLabels obtenido = objeto.readTableWithLabels(fichero2);

        assertEquals(0, obtenido.getRowAt(2).getNumberClass());
        assertEquals(1, obtenido.getRowAt(55).getNumberClass());
    }
}