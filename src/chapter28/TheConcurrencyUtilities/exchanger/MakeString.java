package chapter28.TheConcurrencyUtilities.exchanger;

import java.util.concurrent.Exchanger;

public class MakeString implements Runnable {
    Exchanger<String> ex;
    String s;

    public MakeString(Exchanger<String> e) {
        ex = e;
        s = new String();
        new Thread(this).start();
    }

    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++)
                s += (char) ch++;
            try {
                s = ex.exchange(s); //обмен, когда и второй поток вызовет этот метод //V exchange(V objRef, long wait, TimeUnit tu)
                System.out.println("Получено в MakeString: " + s);
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}
