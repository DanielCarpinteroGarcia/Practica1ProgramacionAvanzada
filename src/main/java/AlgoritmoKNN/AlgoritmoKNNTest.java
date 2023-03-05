package AlgoritmoKNN;

import LecturaDatosCSV.CSV;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgoritmoKNNTest {
    AlgoritmoKNN obj = new AlgoritmoKNN();
    CSV obj2 = new CSV();
    @Test
    void estimate() throws FileNotFoundException {
        List<Double> lista = new ArrayList<>();
        lista.add(4.6);
        lista.add(3.1);
        lista.add(1.4);
        lista.add(0.3);
        List<Double> lista2 = new ArrayList<>();
        lista2.add(7.0);
        lista2.add(3.3);
        lista2.add(4.6);
        lista2.add(1.2);
        obj.train(obj2.readTableWithLabels("iris.csv"));
        assertEquals(0, obj.estimate(lista));
        assertEquals(1, obj.estimate(lista2));
    }

    @Test
    void distancia(){
        assertEquals( 2.3, obj.distancia(3.40, 1.10));
        assertEquals(0.9, obj.distancia(4.3, 5.2), 0.3d);
        assertEquals(0, obj.distancia(0.0, 0.0));
    }

}