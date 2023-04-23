package Tests;

import Algoritmos.KMeans;
import Rows.Row;
import Tables.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class KMeansTest {
    KMeans kMeans = new KMeans();
    Table table = new Table();

    @Test
    void estimate() {
        List<Row> r = new ArrayList<>();
        List<Double> l1 = new ArrayList<>(Arrays.asList(4.4, 4.2, 4.6));
        List<Double> l12 = new ArrayList<>(Arrays.asList(4.1, 4.2, 4.4));
        List<Double> l13 = new ArrayList<>(Arrays.asList(4.0, 4.7, 4.2));
        table.addRow(l1);
        table.addRow(l12);
        table.addRow(l13);

        List<Double> l2 = new ArrayList<>(Arrays.asList(0.5, 0.3, 0.2));
        List<Double> l22 = new ArrayList<>(Arrays.asList(0.6, 0.8, 0.7));
        table.addRow(l2);
        table.addRow(l22);

        List<Double> l3 = new ArrayList<>(Arrays.asList(8.9, 8.5, 8.3));
        List<Double> l32 = new ArrayList<>(Arrays.asList(8.7, 8.2, 8.1));
        List<Double> l34 = new ArrayList<>(Arrays.asList(8.5, 8.7, 8.2));
        List<Double> l35 = new ArrayList<>(Arrays.asList(8.1, 8.4, 8.2));
        table.addRow(l3);
        table.addRow(l32);
        table.addRow(l34);
        table.addRow(l35);

        r.add(table.getRowAt(0));
        r.add(table.getRowAt(3));
        r.add(table.getRowAt(8));
        kMeans.setRepresentantes(r);

        int r1 = kMeans.estimate(l12);
        int r2 = kMeans.estimate(l22);
        int r3 = kMeans.estimate(l3);
        int r4 = kMeans.estimate(l35);

        //Comprobación: Un dato se asigna correctamente a su grupo, con dos datos de grupos distintos
        assertEquals(0, r1);
        assertEquals(1, r2);

        //Comprobación con datos del mismo grupo
        assertEquals(2, r3);
        assertEquals(2, r4);
    }
}