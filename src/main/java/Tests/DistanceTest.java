package Tests;

import Distancias.Distance;
import Distancias.EuclideanDistance;
import Distancias.ManhattanDistance;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DistanceTest {

    @Test
    public void distance() {
        Distance distance = new EuclideanDistance();
        List<Double> list1 = new ArrayList<>(Arrays.asList(0.0,1.0));
        List<Double> list2 = new ArrayList<>(Arrays.asList(0.0,0.0));

        //Distancia Euclidean
        double res = distance.calculateDistance(list1,list2);
        assertEquals(1.0,res,0.1);

        list1.add(0.0);
        list2.add(1.0);

        res = distance.calculateDistance(list1,list2);
        assertEquals(1.4,res,0.1);

        distance = new ManhattanDistance();

        //Distancia Manhattan
        res = distance.calculateDistance(list1,list2);
        assertEquals(2.0,res,0.1);

        //Mismos puntos tienen misma distancia = 0.0
        res = distance.calculateDistance(list1,list1);
        assertEquals(0.0,res,0.1);

    }
}
