package LecturaCSV;

import Tables.Table;
import Tables.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVTemplateTest {
    @Test
    void readTable() {
        String fichero = "miles_dollars.csv";
        ReaderTemplate objeto = new CSVUnlabeledFileReader(fichero);
        Table table = null;
        try {
            table = objeto.readTableFromSource();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(25, table.getRows().size());
        assertEquals(2, table.getHeaders().size());


        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        assertEquals(l, table.getHeaders());

        List<Double> resul = new ArrayList<>();
        resul.add(1211.0);
        resul.add(1802.0);
        List<Double> obt = table.getRowAt(0).getData();
        assertEquals(resul, obt);

        //En este método no se comprueba si el número que se le asigna a cada fila es correcto ya que no guarda números de fila.
    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() {
        //Aquí solo comprobamos si el número que se asigna a cada fila es correcto,
        // el resto de comprobaciones ya están realizadas en el primer test.
        String fichero2 = "iris.csv";
        ReaderTemplate objeto = new CSVLabeledFileReader(fichero2);
        TableWithLabels table = null;
        try {
            table = (TableWithLabels) objeto.readTableFromSource();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, table.getRowAt(2).getNumberClass());
        assertEquals(1, table.getRowAt(55).getNumberClass());
    }
}
