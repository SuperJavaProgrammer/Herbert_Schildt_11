package chapter9.PackagesAndInterfaces.p2;

import chapter9.PackagesAndInterfaces.p1.D;

public class C implements D { //класс реализует все обязательные методы интерфейса

    public void callb(int a3){
        System.out.println(a3 + INTER3);
    }

    public void calld(int a3){
        System.out.println(a3 + INTER3);
    }

    public void callbb (String par){ //своя реализация, перегружает ту, что по умолчанию
        D.super.callbb("use interface method");
        System.out.println("Не по умполчанию " + par);
    }
}
