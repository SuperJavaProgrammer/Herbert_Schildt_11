package chapter11.MultithreadedProgramming.orders;

import java.util.Random;

class Order {
    private int n;
    private boolean send = false; //флаг, заказ отправлен
    private Random r = new Random();

    synchronized void get() {
        while (!send) { //пока заказ не отправлен, то
            try {
                wait(); //ждем
            } catch (InterruptedException e) { }
        }
        int time = r.nextInt(20) * 100; //определить время на получение
        try {
            Thread.sleep(time); //отстоять в очереди...
        } catch (InterruptedException e) { }
        System.out.println("Получено " + n + ", время " + time); //получили
        send = false; //флаг, что заказ не отправлен
        notify(); //уведомляем, что можно другому потоку продолжать выполнение, то есть отправлять
    }

    synchronized void put (int n) {
        while (send) { //пока заказ не получен, то
            try {
                wait(); //ждем
            } catch (InterruptedException e) { }
        }
        int time = r.nextInt(40) * 100; //определить время на отправку
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) { }
        this.n = n;
        System.out.println("Отправлено " + n + ", время " + time); //отправили
        send = true; //флаг, что заказ не отправлен
        notify(); //уведомляем, что можно другому потоку продолжать выполнение, то есть получать
    }
}
