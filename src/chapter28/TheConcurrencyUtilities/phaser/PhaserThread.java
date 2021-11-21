package chapter28.TheConcurrencyUtilities.phaser;

import java.util.concurrent.Phaser;

public class PhaserThread implements Runnable {
    Phaser ph;
    String name;

    public PhaserThread(Phaser p, String n) {
        ph = p;
        name = n;
        ph.register(); //зарегистрировать фазу
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Поток " + name + " начинает нулевую фазу");
        ph.arriveAndAwaitAdvance();	//ожидать окончания от остальных потоков 1Ф
        try {
            Thread.sleep(10);
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("Поток " + name + " начинает первую фазу");
        ph.arriveAndAwaitAdvance();	//ожидать окончания от остальных потоков 2Ф
        try {
            Thread.sleep(10);
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("Поток " + name + " начинает вторую фазу");
        ph.arriveAndAwaitAdvance();	//ожидать окончания от остальных потоков 3Ф
        ph.arriveAndDeregister(); //завершить
    }
}
