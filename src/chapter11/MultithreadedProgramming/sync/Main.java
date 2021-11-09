package chapter11.MultithreadedProgramming.sync;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Sync sync = new Sync(); //класс с общим ресурсом, проверка синхронизации
        Thread t5 = new Thread(new NewThreadSync(sync, "oneSync")); //создать 3 потока для обращения к общему ресурсу
        Thread t6 = new Thread(new NewThreadSync(sync, "twoSync"));
        Thread t7 = new Thread(new NewThreadSync(sync, "threeSync"));
        t5.start(); //запустить их
        t6.start();
        t7.start();
//        [Part1 oneSync][Part2 oneSync]
//        [Part1 threeSync][Part2 threeSync]
//        [Part1 twoSync][Part2 twoSync]

//        Если не использовать synchronized (sync)
//        [Part2 threeSync[Part2 oneSync[Part2 twoSync]
//        ]
//        ]

    }

}

