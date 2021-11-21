package chapter28.TheConcurrencyUtilities.exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();
        new MakeString(ex);
        new UseString(ex);
    }
}
