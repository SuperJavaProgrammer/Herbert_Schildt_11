package chapter28.TheConcurrencyUtilities.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread implements Runnable {
    CyclicBarrier cb;
    String name;

    public CyclicBarrierThread(CyclicBarrier c, String n) {
        cb = c;
        name = n;
    }

    public void run() {
        System.out.println("Start " + name);
        try {
            System.out.println(name + " ожидает остальных");
            cb.await();	//ожидать всех остальных //int await(long wait, TimeUnit tu)
        } catch(InterruptedException | BrokenBarrierException exc) {
            System.out.println(exc);
        }
    }
}
