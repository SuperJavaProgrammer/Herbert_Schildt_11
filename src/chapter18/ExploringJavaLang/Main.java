package chapter18.ExploringJavaLang;

import chapter12.EnumerationsAutoboxingAndAnnotations.MyAnnotation;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Number number; //abstract class. byte byteValue() and so on...
        //Double, Float, Byte, Short, Integer, and Long - не примитивные типы, классы-оболочки
        //Float(double num); Float(float num); Float(String str) throws NumberFormatException - старые конструкторы. Использовать valueOf()
        Double d = 1.0 / 0;
        System.out.println(d.isInfinite() + " " + d.isNaN()); //true false
        d = 0.0 / 0;
        System.out.println(d.isInfinite() + " " + d.isNaN()); //false true
        System.out.println(Double.toHexString(125850.54)); //0x1.eb9a8a3d70a3dp16
        System.out.println(Double.parseDouble("125850.54")); //125850.54
        System.out.println(Double.isFinite(125850.54)); //true
        d = 500.78;
        System.out.println(d.longValue()); //500
        System.out.println(d.compareTo(400.9)); //1
        System.out.println(Double.compare(400.9, 850.7)); //-1
        System.out.println(Double.sum(400.9, 850.7)); //1251.6
        System.out.println(Double.min(400.9, 850.7)); //400.9
        System.out.println(Double.max(400.9, 850.7)); //850.7

        System.out.println(Integer.toBinaryString(100)); //1100100
        System.out.println(Integer.toOctalString(100)); //144
        System.out.println(Integer.toHexString(100)); //64

        System.out.println(Character.isDigit('9')); //true
        System.out.println(Character.isLetter('a')); //true
        System.out.println(Character.isLetterOrDigit('b')); //true
        System.out.println(Character.isLowerCase('c')); //true
        System.out.println(Character.isUpperCase('T')); //true
        System.out.println(Character.isWhitespace(' ')); //true
        System.out.println(Character.toLowerCase('T')); //t
        System.out.println(Character.toUpperCase('t')); //T

        Runtime r = Runtime.getRuntime();
        System.out.println("Total memory:" + r.totalMemory()); //117440512
        System.out.println("Free memory:" + r.freeMemory()); //114327464
        System.out.println(Runtime.version()); //11.0.4+10-b304.77
        try {
            Process p = r.exec("Notepad"); //Notepad, calc //открытие внешних программ
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "MyFileName");
            pb.start(); //открытие внешних программ (блокнот с именем файла MyFileName)
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis()); //1637004289734
        System.out.println(System.nanoTime()); //193091120315300
        byte[] a = {49, 120, 98, 78};
        byte[] b = new byte[4];
        System.arraycopy(a, 0, b, 0, 4); //быстрое копирование массивов (из a в b)
        System.out.println(new String(b));
        System.out.println(System.getProperty("user.name") + " " + System.getProperty("user.dir")); //BillGates D:\Java\Schildt\Herbert_Schildt_11

        Object o;
        //Class<?> getClass(), int hashCode(), boolean equals(Object obj), Object clone(), String toString(), void notify(), void notifyAll(), void wait(), void wait(long var1), void wait(long timeoutMillis, int nanos)

        Box b1 = new Box(45, 76, 36);
        Box b2 = b1.cloneBox(); //свои реализации clone
        Box b3 = Box.cloneBox(b2);
        Box b4 = (Box) b3.clone(); //переопределение clone из Object
        System.out.println("b1=" + b1 + "\nb2=" + b2 + "\nb3=" + b3 + "\nb4=" + b4); //везде Dimension: a=45, b=76, c=36

        Class<?> c = b1.getClass();
        Annotation[] ans = c.getAnnotations(); //getDeclaredAnnotations
        Annotation[] ans2 = c.getDeclaredAnnotations();
        Annotation an = c.getAnnotation(MyAnnotation.class);
        Constructor[] cs = c.getConstructors();
        Field[] fs = c.getFields();
        Method[] ms = c.getMethods();
        Class<?>[] its = c.getInterfaces();
        Module m = c.getModule();
        String name = c.getName();
        String packageName = c.getPackageName();
        Class<?> superclass = c.getSuperclass();
        boolean isInterface = c.isInterface();

        System.out.println("" + Math.sqrt(81) + " " + Math.pow(5, 3) + " " + Math.sin(Math.PI) + " " + Math.cos(Math.E)); //9.0 125.0 1.2246467991473532E-16 -0.9117339147869651
        System.out.println("" + Math.abs(-8.1) + " " + Math.ceil(5.4) + " " + Math.floor(6.7) + " " + Math.round(6.5)); //8.1 6.0 6.0 7
        System.out.println("" + Math.min(6, 7) + " " + Math.max(6, 7) + " " + Math.hypot(3, 4) + " " + Math.random()); //6 7 5.0 0.28218440531684175
        System.out.println("" + Math.toDegrees(1.5) + " " + Math.toRadians(90)); //85.94366926962348 1.5707963267948966
        System.out.println(StrictMath.sin(10)); //-0.5440211108893698

        Thread th = new Thread(); //Thread(Runnable threadOb), Thread(Runnable threadOb, String threadName), Thread(String threadName), Thread(ThreadGroup groupOb, Runnable threadOb), Thread(ThreadGroup groupOb, Runnable threadOb, String threadName), Thread(ThreadGroup groupOb, String threadName)
        Thread th1 = Thread.currentThread(); //void sleep(long var0), void start(), void interrupt(), boolean isInterrupted(), void setPriority(int newPriority), getPriority(), void setName(String name), String getName(), ThreadGroup getThreadGroup(), void join(), void setDaemon(boolean on), boolean isDaemon(), Thread.State getState(), void yield()
        ThreadGroup thGr = new ThreadGroup("groupName"); //ThreadGroup(ThreadGroup parentOb, String groupName)

        for (Package aPackage : Package.getPackages())
            System.out.println(aPackage.getName() + " " + aPackage.getImplementationTitle());

        StackTraceElement[] getStackTrace = new RuntimeException().getStackTrace();

        CharSequence charSequence; //This interface is implemented by String, StringBuffer, and StringBuilder
        Comparable comparable; //int compareTo(T obj) //classes that implement Comparable contain objects that can be compared in some meaningful manner
        Appendable appendable; //append(char ch), append(CharSequence chars), append(CharSequence chars, int begin, int end) //can have a character or character sequences appended to it
        Iterable iterable; //Iterator<T> iterator(), default void forEach(Consumer<? super T> action), default Spliterator<T> spliterator() //must be implemented by any class whose objects will be used by the for-each version of the for loop
        Readable readable; //int read(CharBuffer buf) throws IOException //an object can be used as a source for characters
        AutoCloseable autoCloseable; //void close() throws Exception //provides support for the try-with-resources statement, which implements what is sometimes referred to as automatic resource management

    }
}

