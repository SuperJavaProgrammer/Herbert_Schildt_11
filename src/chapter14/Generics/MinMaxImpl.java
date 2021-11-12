package chapter14.Generics;

public class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> { //класс реализует обобщенный интерфейс
    T num1;
    T num2;

    MinMaxImpl(T n1, T n2) {
        num1 = n1;
        num2 = n2;
    }

    @Override
    public T min() {
        T min = num1.compareTo(num2) < 0 ? num1 : num2;
        System.out.println("min=" + min);
        return min;
    }

    @Override
    public T max() {
        T max = num1.compareTo(num2) > 0 ? num1 : num2;
        System.out.println("max=" + max);
        return max;
    }

    T getNum1() {
        return num1;
    }
}
