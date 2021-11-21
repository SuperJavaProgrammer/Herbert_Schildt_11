package chapter28.TheConcurrencyUtilities;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) {
        //Synchronizers
        Semaphore semaphore; //controls access to a shared resource through the use of a counter
        CountDownLatch countDownLatch; //a thread will wait until one or more events have occurred
        CyclicBarrier cyclicBarrier; //a set of two or more threads must wait at a predetermined execution point until all threads in the set have reached that point
        Exchanger exchanger; //it waits until two separate threads call its exchange() method. When that occurs, it exchanges the data supplied by the threads
        Phaser phaser; //to enable the synchronization of threads that represent one or more phases of activity. Works a bit like a CyclicBarrier, except that it supports multiple phases

        //Executors
        Executor executor; //interface Executor. //initiates and controls the execution of threads
        //void execute(Runnable var1);
        ExecutorService executorService; //interface ExecutorService extends Executor
        //void shutdown();
        //boolean isShutdown();
        //boolean isTerminated();
        //boolean awaitTermination(long var1, TimeUnit var3);
        //List<Runnable> shutdownNow();
        //<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> var1);
        //<T> T invokeAny(Collection<? extends Callable<T>> var1);
        //Future<?> submit(Runnable var1);
        ThreadPoolExecutor threadPoolExecutor; //class ThreadPoolExecutor extends AbstractExecutorService
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor; //class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService
        ForkJoinPool forkJoinPool; //class ForkJoinPool extends AbstractExecutorService
        Callable callable; //interface Callable<V> //represents a thread that returns a value
        //V call() throws Exception;
        Future future; //interface Future<V> //represents the value that will be returned by a Callable object
        //boolean isDone();
        //boolean isCancelled();
        //boolean cancel(boolean var1);
        //V get();
        //V get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException;
        TimeUnit timeUnit; //enum TimeUnit //NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS

        //Concurrent collections
        ArrayBlockingQueue arrayBlockingQueue;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentLinkedDeque concurrentLinkedDeque;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        ConcurrentSkipListMap concurrentSkipListMap;
        ConcurrentSkipListSet concurrentSkipListSet;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArraySet copyOnWriteArraySet;
        DelayQueue delayQueue;
        LinkedBlockingDeque linkedBlockingDeque;
        LinkedBlockingQueue linkedBlockingQueue;
        LinkedTransferQueue linkedTransferQueue;
        PriorityBlockingQueue priorityBlockingQueue;
        SynchronousQueue synchronousQueue;

        //The Fork/Join Framework
        ForkJoinTask forkJoinTask;
        ForkJoinPool forkJoinPool1;
        RecursiveTask recursiveTask;
        RecursiveAction recursiveAction;

        //java.util.concurrent.atomic //offers methods that get, set, or compare the value of a variable in one uninterruptible (that is, atomic) operation. This means that no lock or other synchronization mechanism is required.
        AtomicInteger atomicInteger; //AtomicLong atomicLong;...
        //void set(int newValue)
        //boolean compareAndSet(int expectedValue, int newValue)
        //boolean weakCompareAndSetVolatile(int expectedValue, int newValue)
        //int get()
        //int getAndSet(int newValue)
        //int getAndIncrement()
        //int getAndDecrement()
        //int getAndAdd(int delta)
        //int getAndUpdate(IntUnaryOperator updateFunction)
        //int getAndAccumulate(int x, IntBinaryOperator accumulatorFunction)
        //int incrementAndGet()
        //int decrementAndGet()
        //int addAndGet(int delta)
        //int updateAndGet(IntUnaryOperator updateFunction)
        //int accumulateAndGet(int x, IntBinaryOperator accumulatorFunction)
        //int compareAndExchange(int expectedValue, int newValue)
        //int compareAndExchangeAcquire(int expectedValue, int newValue)
        //int compareAndExchangeRelease(int expectedValue, int newValue)
        //DoubleAccumulator, DoubleAdder, LongAccumulator, LongAdder //support lock-free cumulative operations

        //java.util.concurrent.locks
        Lock lock; //interface Lock //objects that offer an alternative to using synchronized to control access to a shared resource
        //void lock();
        //void lockInterruptibly();
        //void unlock();
        //boolean tryLock();
        //boolean tryLock(long var1, TimeUnit var3);
        //Condition newCondition();
        ReentrantLock reentrantLock; //class ReentrantLock implements Lock, Serializable
        ReadWriteLock readWriteLock; //interface ReadWriteLock //specifies a lock that maintains separate locks for read and write access
        //Lock readLock();
        //Lock writeLock();
        ReentrantReadWriteLock reentrantReadWriteLock; //class ReentrantReadWriteLock implements ReadWriteLock, Serializable
        StampedLock stampedLock; //class StampedLock implements Serializable //provide a mechanism that enables aspects of it to be used like a Lock or ReadWriteLock

        ExecutorService es = Executors.newFixedThreadPool(2);
        System.out.println("Start ExecutorService");
        es.execute(() -> System.out.println("Hello"));
        es.execute(() -> System.out.println("Hola"));
        es.execute(() -> System.out.println("Привет"));
        es.execute(() -> System.out.println("Salut"));
        System.out.println("Done");

        System.out.println("Start Future");
        Future<Integer> intF = es.submit(() -> (int) Math.sqrt(500));
        Future<Double> doubleF = es.submit(() -> Math.sqrt(500));;
        Future<String> stringF = es.submit(() -> "" + Math.sqrt(500));
        try {
            System.out.println("intF=" + intF.get());
            System.out.println("doubleF=" + doubleF.get(20, TimeUnit.MILLISECONDS));
            System.out.println("stringF=" + stringF.get(1, TimeUnit.SECONDS));
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("Done");
    }
}
