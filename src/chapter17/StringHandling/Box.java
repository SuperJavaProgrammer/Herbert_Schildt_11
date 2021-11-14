package chapter17.StringHandling;

public class Box {
    int a;
    int b;
    int c;

    Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return "Dimension: a=" + a + ", b=" + b + ", c=" + c;
    }
}
