package chapter14.Generics;

public class MinMaxImplSub<T extends Comparable<T>, V> extends MinMaxImpl<T> { //класс расширяет обобщенный класс и добавляет свой новый обобщенный элемент
    V num3;

    MinMaxImplSub(T n1, T n2, V n3) {
        super(n1, n2);
        num3 = n3;
        System.out.println("Subclass");
    }

    T getNum1() {
        System.out.println("override getNum1()");
        return num1;
    }

    V getNum3() {
        return num3;
    }
}
