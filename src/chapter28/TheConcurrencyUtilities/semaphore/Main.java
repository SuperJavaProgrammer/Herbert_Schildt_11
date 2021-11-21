package chapter28.TheConcurrencyUtilities.semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);	//семафор на 1 поток //new Semaphore(1, true); waiting threads are granted a permit in the order in which they requested access
        new Thread(new DecThread(sem, "A")).start();
        new Thread(new IncThread(sem, "B")).start();
    }
}
