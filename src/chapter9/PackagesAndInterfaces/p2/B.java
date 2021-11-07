package chapter9.PackagesAndInterfaces.p2;

import chapter9.PackagesAndInterfaces.p1.D;

abstract class B implements Cb.innerInt, D { //класс реализует 2 интерфейса, один из которых внутренний, но реализует все методы интерфейса, поэтому он абстрактный
    void callc(){
        System.out.println("10");
    }
}
