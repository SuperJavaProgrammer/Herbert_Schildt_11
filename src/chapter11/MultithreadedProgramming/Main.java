package chapter11.MultithreadedProgramming;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t = Thread.currentThread(); //получить текущий поток исполнения
        System.out.println("Current thread:" + t); //Thread[main,5,main]
        t.setName("newName"); //поменять имя
        System.out.println("Change name:" + t + " Check=" + t.getName()); //Thread[newName,5,main] Check=newName
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            Thread.sleep(1000); //остановить на 1000мс
            Thread.sleep(1000, 10); //остановить на  1000мс 10нс
        }

        Thread t1 = new Thread(new NewThreadInt("oneInt")); //создать свой новый поток через реализацию интерфейса Runnable
        Thread t2 = new Thread(new NewThreadInt("twoInt"), "name"); //еще указать имя
        System.out.println("State before start " + t1.getState()); //состояние потока до запуска //start NEW
        t1.setPriority(1); //задать приоритет 1-10
        t2.setPriority(10);
        t1.start(); //запустить потоки на исполнение
        t2.start();
        System.out.println("State after start " + t1.getState()); //состояние потока после запуска //start RUNNABLE
        System.out.println("Alive=" + t1.isAlive() + " " + t1.isAlive()); //проверка, живые ли потоки //Alive=true true
        t1.join(); //ожидать остановки потока
        t2.join();
        System.out.println("State after finish " + t1.getState()); //состояние потока после завершения //State after finish TERMINATED
        System.out.println("Alive=" + t1.isAlive() + " " + t1.isAlive()); //проверка, живые ли потоки после завершения //Alive=false false

        NewThreadClass t3 = new NewThreadClass("oneClass"); //создать свой новый поток через расширение класса Thread
        NewThreadClass t4 = new NewThreadClass("twoClass");
        t3.start(); //запустить
        t4.start();
    }

}

