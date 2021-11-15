package chapter18.ExploringJavaLang;

public class Box implements Cloneable{ //CloneNotSupportedException if not
    int a;
    int b;
    int c;

    Box() { }

    Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Box cloneBox() { //метод клонирования
        try {
            return (Box) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error Clone");
            return this;
        }
    }

    static Box cloneBox(Box box) { //статический метод клонирования
        try {
            return (Box) box.clone();
        } catch (Exception e) {
            System.out.println("Error Clone");
            return box;
        }
    }

    @Override
    public Object clone() { //переопределенный метод клонирования класса Object
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error clone()");
            return this;
        }
    }

    public String toString() {
        return "Dimension: a=" + a + ", b=" + b + ", c=" + c;
    }
}
