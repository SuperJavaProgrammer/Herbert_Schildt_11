package chapter28.TheConcurrencyUtilities.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread implements Runnable {
    CountDownLatch cdl;

    public CountDownLatchThread(CountDownLatch c) {
        cdl = c;
    }

    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println(i);
            cdl.countDown(); //считать вниз до 0
        }
    }
}
