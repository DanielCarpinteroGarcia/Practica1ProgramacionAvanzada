package LecturaCSV;

import Rows.Row;
import Tables.Table;
import Tables.TableWithLabels;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CSVTest {
    @org.junit.jupiter.api.Test
    void readTable() throws FileNotFoundException {
        CSV objeto = new CSV();
        String fichero = "miles_dollars.csv";
        Table obtenido = objeto.readTable(fichero);

        //Número de ejemplares o filas leídos.
        assertEquals(25, obtenido.getRows().size());

        //Número de columnas leído.
        int nColumnas = 0;
        for(Row r: obtenido.getRows()){
            nColumnas += r.getData().size();
        }
        assertEquals(50, nColumnas);

        //Nombre de las etiquetas de las cabeceras.
        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        assertEquals(l, obtenido.getHeaders());

        //Recuperar contenidos de las tablas guardadas.
        List<Double> resul = new ArrayList<>();
        resul.add(1211.0);
        resul.add(1802.0);
        List<Double> obt = obtenido.getRowAt(0).getData();
        assertEquals(resul, obt);

        //En este test no se comprueba si el número que se le asigna a cada fila es correcto ya que este método no guarda números de fila.
    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() throws FileNotFoundException {
        //Aquí solo comprobamos si el número que se asigna a cada fila es correcto,
        // el resto de comprobaciones ya están realizadas en el primer test.
        CSV objeto = new CSV();
        String fichero2 = "iris.csv";
        TableWithLabels obtenido = objeto.readTableWithLabels(fichero2);

        assertEquals(0, obtenido.getRowAt(2).getNumberClass());
        assertEquals(1, obtenido.getRowAt(55).getNumberClass());
    }
}
