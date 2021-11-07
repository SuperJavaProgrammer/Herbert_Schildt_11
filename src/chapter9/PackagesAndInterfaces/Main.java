package chapter9.PackagesAndInterfaces;

import chapter9.PackagesAndInterfaces.p1.A;
import chapter9.PackagesAndInterfaces.p1.D;
import chapter9.PackagesAndInterfaces.p2.C;
import chapter9.PackagesAndInterfaces.p2.Cb;

public class Main {

    public static void main(String[] args) { //подглавы в Большой главе комментариями в коде выделить
        Cb a1 = new A(); //объект интерфейса создать нельзя, но можно создать переменная класса, реализующую интерфейс
            a1.callb(50); //Hello! 40
            a1.callbb("Diana"); //По умполчанию Diana
        D b1 = new C();
            b1.callb(100); //130
            b1.calld(200); //230
            b1.callbb("Java"); //По умполчанию use interface method Не по умполчанию Java
        Cb.meth1(30, 40); //вызов статического метода интерфейса //a+b=3040
        System.out.println(Cb.INTER1 + Cb.INTER2 + D.INTER3 + Cb.innerInt.INTER3); //обращение к константам интерфейсов //90
    }
}
