package Algoritmos;

import Tables.Table;

public interface Algorithm<T extends Table, V, W> {
    void train(T d);
    V estimate(W d);
}
