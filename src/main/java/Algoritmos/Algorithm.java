package Algoritmos;

import Tables.Table;

public interface Algorithm <T extends Table, V, W> {
    void train(T data) throws KMeansException;
    V estimate(W data);
}
