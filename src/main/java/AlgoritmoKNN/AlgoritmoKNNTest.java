package AlgoritmoKNN;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgoritmoKNNTest {

    @Test
    void estimate() {
        List<Double> lista = new ArrayList<>();
        lista.add(4.6);
        lista.add(3.1);
        lista.add(1.4);
        lista.add(0.3);
        assertEquals(0, estimate(lista));
    }

}