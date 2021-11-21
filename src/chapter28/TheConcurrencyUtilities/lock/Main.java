package chapter28.TheConcurrencyUtilities.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock rl = new ReentrantLock();
        new Thread(new LockThread(rl, "A")).start();
        new Thread(new LockThread(rl, "B")).start();
    }
}
