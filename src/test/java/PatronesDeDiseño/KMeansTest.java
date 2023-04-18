package PatronesDeDiseño;

import Algoritmos.KMeans;
import Rows.Row;
import Tables.Table;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class KMeansTest {
    KMeans k = new KMeans();
    Table t = new Table();

    @Test
    void estimate() {
        List<Row> r = new ArrayList<>();
        List<Double> l1 = new ArrayList<>(Arrays.asList(4.4, 4.2, 4.6));
        List<Double> l12 = new ArrayList<>(Arrays.asList(4.1, 4.2, 4.4));
        List<Double> l13 = new ArrayList<>(Arrays.asList(4.0, 4.7, 4.2));
        t.addRow(l1);
        t.addRow(l12);
        t.addRow(l13);

        List<Double> l2 = new ArrayList<>(Arrays.asList(0.5, 0.3, 0.2));
        List<Double> l22 = new ArrayList<>(Arrays.asList(0.6, 0.8, 0.7));
        t.addRow(l2);
        t.addRow(l22);

        List<Double> l3 = new ArrayList<>(Arrays.asList(8.9, 8.5, 8.3));
        List<Double> l32 = new ArrayList<>(Arrays.asList(8.7, 8.2, 8.1));
        List<Double> l34 = new ArrayList<>(Arrays.asList(8.5, 8.7, 8.2));
        List<Double> l35 = new ArrayList<>(Arrays.asList(8.1, 8.4, 8.2));
        t.addRow(l3);
        t.addRow(l32);
        t.addRow(l34);
        t.addRow(l35);

        r.add(t.getRowAt(0));
        r.add(t.getRowAt(3));
        r.add(t.getRowAt(8));
        k.setRepresentantes(r);

        int r1 = k.estimate(l12);
        int r2 = k.estimate(l22);
        int r3 = k.estimate(l3);
        int r4 = k.estimate(l35);

        //Comprobación: Un dato se asigna correctamente a su grupo, con dos datos de grupos distintos
        assertEquals(0, r1);
        assertEquals(1, r2);

        //Comprobación con datos del mismo grupo
        assertEquals(2, r3);
        assertEquals(2, r4);
    }
}