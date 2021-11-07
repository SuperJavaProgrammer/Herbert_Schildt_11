package chapter9.PackagesAndInterfaces.p1;

import chapter9.PackagesAndInterfaces.p2.Cb;

public class A implements Cb { //класс реализует интерфейс
    int a; //доступ по умолчанию (пакетный)
    public int b; //переменная доступна везде
    private int c; //переменная доступна только в данном классе
    protected int d; //переменная доступна в данном и производных классах других пакетов

    public void callb(int aaa){	//реализация метода интерфейса
        System.out.println("Hello! " + (aaa + INTER1 - INTER2)); //обращение к константам интерфейса
    }

    void calla(int aaa){ //свой метод
        System.out.println("Bye! " + aaa);
    }
}