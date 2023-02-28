package LecturaDatosCSV;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @org.junit.jupiter.api.Test
    void readTable() {
        CSV objeto = new CSV();
        String fichero = "miles_dollars.csv";
        String fichero2 = "iris.csv";
        Table obtenido = objeto.readTable(fichero);
        Table resultado;
        TableWithLabels obt = objeto.readTableWithLabels(fichero2);
        TableWithLabels resul;
        assertEquals();
    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() {
    }
}