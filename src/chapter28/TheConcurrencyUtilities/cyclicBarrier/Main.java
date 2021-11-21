package chapter28.TheConcurrencyUtilities.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarrierAction()); //CyclicBarrier(int numThreads)
        System.out.println("Запуск потоков исполнения CyclicBarrier");
        new Thread(new CyclicBarrierThread(cb, "A")).start();
        new Thread(new CyclicBarrierThread(cb, "B")).start();
        new Thread(new CyclicBarrierThread(cb, "C")).start();
        new Thread(new CyclicBarrierThread(cb, "AA")).start();
        new Thread(new CyclicBarrierThread(cb, "BB")).start();
        new Thread(new CyclicBarrierThread(cb, "CC")).start();
    }
}
