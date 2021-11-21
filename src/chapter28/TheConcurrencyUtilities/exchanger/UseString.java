package chapter28.TheConcurrencyUtilities.exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable {
    Exchanger<String> ex;
    String s;

    public UseString(Exchanger<String> e) {
        ex = e;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                s = ex.exchange(new String());	//обмен данными с первым потоком
                System.out.println("Получено в UseString: " + s);
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}
