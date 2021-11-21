package chapter28.TheConcurrencyUtilities.semaphore;

import java.util.concurrent.Semaphore;

public class DecThread implements Runnable {
    String name;
    Semaphore sem;

    public DecThread (Semaphore s, String n){
        sem = s;
        name = n;
    }

    public void run() {
        try {
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешения");
            for(int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}
