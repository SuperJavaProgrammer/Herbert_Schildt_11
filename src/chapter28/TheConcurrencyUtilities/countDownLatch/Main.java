package chapter28.TheConcurrencyUtilities.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);	//5 событий для снятия блокировки
        System.out.println("Запуск потока исполнения CountDownLatch");
        new Thread(new CountDownLatchThread(cdl)).start();
        try {
            cdl.await(); //ожидание 5 событий //boolean await(long wait, TimeUnit tu)
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("Завершение потока исполнения");
    }
}
