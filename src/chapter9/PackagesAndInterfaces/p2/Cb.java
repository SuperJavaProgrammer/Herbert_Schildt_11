package chapter9.PackagesAndInterfaces.p2;

public interface Cb {
    int INTER1 = 10; //константа, негласно final public
    int INTER2 = 20;

    interface innerInt { //Внутренний интерфейс
        int INTER3 = 30; //новые константы и методы
        void calld(int par);
    }

    void callb (int param); //метод в интерфейсе

    default void callbb (String par){ //метод по умолчанию
        System.out.println("По умполчанию " + par);
    }
    static void meth1(int a, int b){ //статический метод интерфейса
        System.out.println("a+b=" + a + b);
    }
    default void meth(int a, int b){
        System.out.println("a+b=" + sqrt(a, b));
    }

    private double sqrt(int a, int b) { //приватный метод интерфейса. Новое в 11
        return Math.sqrt(a * a + b * b);
    }

}
