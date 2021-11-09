package chapter11.MultithreadedProgramming;

public class NewThreadInt implements Runnable { //класс реализует Runnable
    String name;

    NewThreadInt(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Start " + name);
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " " + i);
                Thread.sleep(1000);
            }
            System.out.println("Finish " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
