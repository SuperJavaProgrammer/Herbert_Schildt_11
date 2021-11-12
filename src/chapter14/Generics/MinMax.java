package chapter14.Generics;

public interface MinMax<T extends Comparable<T>> { //обобщенный интерфейс, чей обобщенный тип относится к Comparable
    T min();
    T max();
}
