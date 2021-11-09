package chapter11.MultithreadedProgramming;

public class NewThreadClass extends Thread { //класс расширяет Thread
    String name;

    NewThreadClass(String name) {
        super(name);
        this.name = name;
    }

    @Override //точка запуска потока
    public void run() {
        try {
            System.out.println("Start " + name);
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " " + i);
                Thread.sleep(1000); //усыпить поток на 1сек
            }
            System.out.println("Finish " + name);
        } catch (InterruptedException e) { //может возникнуть исключение InterruptedException
            e.printStackTrace();
        }
    }
}
