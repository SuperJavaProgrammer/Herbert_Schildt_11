package chapter28.TheConcurrencyUtilities.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser ph = new Phaser(1); //Phaser() creates a phaser that has a registration count of zero
        int curPhase;
        System.out.println("Запуск потоков Phaser");
        new PhaserThread(ph, "Ap");
        new PhaserThread(ph, "Bp");
        new PhaserThread(ph, "Cp");
        curPhase = ph.getPhase();	//текущая фаза
        ph.arriveAndAwaitAdvance();	//ожидать завершения от всех
        System.out.println("Фаза " + curPhase + " завершена");
        curPhase = ph.getPhase();
        ph.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");
        curPhase = ph.getPhase();
        ph.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");
        ph.arriveAndDeregister();	//завершение
        if(ph.isTerminated())
            System.out.println("Синхронизатор фаз завершен");
    }
}
