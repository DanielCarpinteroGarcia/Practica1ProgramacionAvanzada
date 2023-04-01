package Algoritmos;

import Tables.Table;

public interface Algorithm<T> {
    T train(T d);
    T estimate(T d);
}
