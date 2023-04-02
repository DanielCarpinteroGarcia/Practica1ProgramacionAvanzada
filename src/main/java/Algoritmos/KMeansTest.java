package Algoritmos;

import Tables.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class KMeansTest {
    KMeans k = new KMeans();
    Table t = new Table();
    @Test
    void estimate() {
    }

    @Test
    void train() {
        List<Double> l1 = new ArrayList<>();
        l1.add(2.4);
        l1.add(2.2);
        l1.add(2.5);
        t.addRow(l1);
        List<Double> l2 = new ArrayList<>();
        l2.add(1.5);
        l2.add(1.3);
        l2.add(1.2);
        t.addRow(l2);
        List<Double> l3 = new ArrayList<>();
        l3.add(8.9);
        l3.add(8.5);
        l3.add(8.3);
        t.addRow(l3);
        assertEquals(0, k.estimate(l1));
        assertEquals(1, k.estimate(l2));
    }

    @Test
    void asignar_grupo() {
    }

    @Test
    void distancia() {
    }
}