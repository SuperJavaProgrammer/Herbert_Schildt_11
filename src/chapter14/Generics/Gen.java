package chapter14.Generics;

import java.io.Serializable;

public class Gen<T extends Serializable, V> { //обобщенный класс, принимает 2 обобщенных типа T(относится к Serializable) и V
//    static T t; 1) нельзя создать статичекую переменную обобщенного типа
    T t; //обобщенная переменная
    V v;

    Gen(T o1, V o2) { //конструктор с 2 обобщенными параметрами
        t = o1;
        v = o2;
    }

    <E extends Number> Gen(E arg) { //конструктор, может принимать 1 обобщенный параметр, относящийся к Number
        System.out.println(arg.getClass().getName());
    }

    public T getT() { //вернуть обобщенную переменную
        return t;
    }

    public V getV() {
        return v;
    }

//    static void show() { 2) нельзя создать статический метод(использует обобщенную переменную)
    void show() {
//        t = new T(); 3) нельзя создать новый объект обобщенного типа
//        T[] tar = new T[10]; 4) нельзя создать массив из обобщенных объектов
        System.out.println("T is type=" + t.getClass().getName() + " Value=" + t);
        System.out.println("V is type=" + v.getClass().getName() + " Value=" + v);
    }

    void same(Gen<? extends Number, ? super String> gen) { //метасимвол, верхняя и нижная граница
        if (gen.getT().equals(t) && gen.getV().equals(v))
            System.out.println("same");
        else
            System.out.println("different");
    }
}
