package chapter9.PackagesAndInterfaces.p1;

import chapter9.PackagesAndInterfaces.p2.Cb;

public interface D extends Cb { //интерфейс расширяет другой интерфейс
    int INTER3 = 30;//новые константы и методы
    void calld(int par);
}

