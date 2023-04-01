package Algoritmos;

import Tables.Table;

public interface Algorithm<T extends Table> {
    void train(T d);
    T estimate(T d);
}
