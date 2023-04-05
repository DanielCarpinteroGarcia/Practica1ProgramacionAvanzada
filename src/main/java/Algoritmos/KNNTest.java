package Algoritmos;

import LecturaCSV.CSV;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {
    KNN objKNN = new KNN();
    CSV objCSV = new CSV();

    @Test
    void estimate() {
        List<Double> list1 = new ArrayList<>(Arrays.asList(4.6, 3.1, 1.4, 0.3));
        List<Double> list2 = new ArrayList<>(Arrays.asList(7.0, 3.3, 4.6, 1.2));
        List<Double> list3 = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0));
        objKNN.train(objCSV.readTableWithLabels("iris.csv"));
        assertEquals(0, objKNN.estimate(list1));
        assertEquals(1, objKNN.estimate(list2));
        assertEquals(0,objKNN.estimate(list3));

    }

    @Test
    void distancia(){
        assertEquals( 2.3, objKNN.distancia(3.40, 1.10));
        assertEquals(0.9, objKNN.distancia(4.3, 5.2), 0.3d);
        assertEquals(0, objKNN.distancia(0.0, 0.0));
    }

}
