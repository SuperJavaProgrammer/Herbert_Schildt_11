package chapter11.MultithreadedProgramming.orders;

public class Main {
    public static void main(String[] args) {
        var order = new Order(); //класс для заказов
        new Producer(order); //запустить поставщика заказов
        new Consumer(order); //запустить потребителя заказов
    }
}
