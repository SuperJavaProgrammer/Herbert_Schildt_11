package chapter11.MultithreadedProgramming.sync;

public class NewThreadSync implements Runnable { //поток для проверки синхронизации
    String name;
    Sync sync;

    public NewThreadSync(Sync sync, String name) {
        this.name = name;
        this.sync = sync;
    }

    @Override
    public void run() {
        sync.callSync(name); //вызов синхронизованного метода
        synchronized (sync) { //вызов синхронизованного блока, если идет обращение к методу, который у себя внутри не синхронизован
            sync.callNotSync(name);
        }
    }

}
