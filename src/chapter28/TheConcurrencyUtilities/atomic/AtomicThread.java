package chapter28.TheConcurrencyUtilities.atomic;

public class AtomicThread implements Runnable {
    String name;

    public AtomicThread(String n) {
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Start " + name);
        for (int i = 0; i < 3; i++) {
//            Shared.ai = i;
            System.out.println(name + " got: " + Shared.ai.getAndSet(i));
        }
    }
}
