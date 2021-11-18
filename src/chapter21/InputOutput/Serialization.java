package chapter21.InputOutput;

import java.io.Serializable;

public class Serialization implements Serializable { //класс для проверки сериализации
    private String s;
    private int i;
    private double d;
    private boolean b;
    private transient String noSave;
    private Serialization ser; //внутри вложенный класс

    public Serialization() {
    }

    public Serialization(String s, int i, double d, boolean b, String noSave, Serialization ser) {
        this.s = s;
        this.i = i;
        this.d = d;
        this.b = b;
        this.noSave = noSave;
        this.ser = ser;
    }

    @Override
    public String toString() {
        return "Serialization{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                ", b=" + b +
                ", noSave=" + noSave +
                ", ser=" + ser +
                '}';
    }
}
