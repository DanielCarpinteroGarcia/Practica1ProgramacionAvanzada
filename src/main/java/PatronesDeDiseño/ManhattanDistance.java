package PatronesDeDiseño;

import java.util.List;

public class ManhattanDistance implements Distance{

    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        int distancia = 0;
        for(int j = 0; j < p.size(); j++){
            distancia +=  Math.abs(p.get(j) - q.get(j));
        }
        return distancia;
    }
}
