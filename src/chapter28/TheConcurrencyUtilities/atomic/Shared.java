package chapter28.TheConcurrencyUtilities.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Shared {
//    static int ai = 0;
    static AtomicInteger ai = new AtomicInteger(0); //общая переменная
}
