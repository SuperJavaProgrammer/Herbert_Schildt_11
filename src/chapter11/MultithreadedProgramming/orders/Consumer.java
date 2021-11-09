package chapter11.MultithreadedProgramming.orders;

public class Consumer implements Runnable {
    Order order;

    Consumer(Order order) {
        this.order = order;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) //бесконечный цикл
            order.get(); //получать заказ
    }
}
