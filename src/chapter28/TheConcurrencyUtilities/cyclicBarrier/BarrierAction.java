package chapter28.TheConcurrencyUtilities.cyclicBarrier;

public class BarrierAction implements Runnable { //делать это, когда все потоки придут в одну точку
    public void run() {
        System.out.println("Барьер достигнут!");
    }
}
