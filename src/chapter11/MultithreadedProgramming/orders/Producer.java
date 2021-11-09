package chapter11.MultithreadedProgramming.orders;

public class Producer implements Runnable {
    Order order;

    Producer(Order order) {
        this.order = order;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 1;
        while (true) //бесконечный цикл
            order.put(i++); //отправлять заказ
    }
}
