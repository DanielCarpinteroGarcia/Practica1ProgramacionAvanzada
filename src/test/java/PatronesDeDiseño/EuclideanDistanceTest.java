package PatronesDeDiseño;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanDistanceTest {
    EuclideanDistance obj = new EuclideanDistance();
    @Test
    void calculateDistance() {
        List<Double> lista = new ArrayList<>(Arrays.asList(0.0,4.0,8.0,3.0));
        List<Double> lista2 = new ArrayList<>(Arrays.asList(2.0,4.0,6.0,5.0));
        List<Double> lista3 = new ArrayList<>(Arrays.asList(1.0,3.0,7.0,9.0));
        List<Double> lista4 = new ArrayList<>(Arrays.asList(1.0,3.0,7.0,9.0));
        List<Double> lista5 = new ArrayList<>(Arrays.asList(4.0,5.0,1.0,9.0));
        List<Double> lista6 = new ArrayList<>(Arrays.asList(8.0,1.0,3.0,6.0));
        assertEquals(3.46, obj.calculateDistance(lista, lista2), 2);
        assertEquals(0, obj.calculateDistance(lista3, lista4));
        assertEquals(6.70, obj.calculateDistance(lista5, lista6),2);
    }
}