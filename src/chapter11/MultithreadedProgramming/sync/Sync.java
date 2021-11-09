package chapter11.MultithreadedProgramming.sync;

public class Sync { //класс, куда будут обращаться несколько потоков, должен быть синхронизирован, чтобы не было проблем с данными

    synchronized void callSync(String name) { //только 1 поток может войти в синхронизированный метод
        System.out.print("[Part1 " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("]");
    }

    void callNotSync(String name) { //метод не синхронизирован, потки могут как угодно обращаться
        System.out.print("[Part2 " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }

}
