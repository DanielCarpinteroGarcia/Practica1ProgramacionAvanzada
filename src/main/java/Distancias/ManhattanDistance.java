package Distancias;

import java.util.List;

public class ManhattanDistance implements Distance{
    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        if(p.size() != q.size())
            throw new IndexOutOfBoundsException();

        double resultado = 0.0;
        for (int i = 0; i < p.size(); i++) {
            resultado += Math.abs(p.get(i) - q.get(i));
        }

        return resultado;
    }
}
