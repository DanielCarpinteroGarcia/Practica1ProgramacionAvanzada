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
        Table obtenido = objeto.readTable(fichero);

        System.out.println("Numero de ejemplares o filas leidos.");
        System.out.println("Fichero miles_dollars.csv");
        assertEquals(25, obtenido.getDatos().size());
        System.out.println("Resultado obtenido: " + 25);
        System.out.println("Resultado esperado: " + obtenido.getDatos().size());

        System.out.println();

        System.out.println("Numero de datos leido.");
        int nDatos = 0;
        for(Row r: obtenido.getDatos()){
            nDatos += r.getData().size();
        }
        assertEquals(2, obtenido.getheaders().size());
        System.out.println("Resultado obtenido: " + 2);
        System.out.println("Resultado esperado: " + obtenido.getheaders().size());

        System.out.println();

        System.out.println("Nombre de las etiquetas de las cabeceras.");
        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        assertEquals(l, obtenido.getheaders());
        System.out.println("Resultado obtenido: " + l);
        System.out.println("Resultado esperado: " + obtenido.getheaders());

        System.out.println();

        System.out.println("Recuperar contenidos de las tablas guardadas.");
        List<Double> resul = new ArrayList<>();
        resul.add(1211.0);
        resul.add(1802.0);
        List<Double> obt = obtenido.getRowAt(0).getData();
        assertEquals(resul, obt);
        System.out.println("Resultado obtenido: " + obt);
        System.out.print("Resultado esperado: " + resul);

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