package chapter10.ExceptionHandling;

public class A {

    static void ex() throws Exception {	//метод может вызывать исключения
        NullPointerException npe = new NullPointerException("дeмoнcтpaция"); //объект исключения с установленным именем
            npe.initCause(new ArrayIndexOutOfBoundsException("вышли за пределы массива")); //установить причину, из-за чего возникло это исключение
        throw npe; //выбросить исключение самостоятельно
    }

}
