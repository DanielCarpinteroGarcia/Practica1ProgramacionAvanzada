package Algoritmos;

public interface Algorithm {
    Table<T> train();
    <T> estimate();
}
