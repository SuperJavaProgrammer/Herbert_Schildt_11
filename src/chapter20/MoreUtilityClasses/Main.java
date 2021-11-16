package chapter20.MoreUtilityClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        StringTokenizer stringTokenizer; //StringTokenizer implements Enumeration<Object> //лучше использовать регулярные выражения
        //int countTokens(); boolean hasMoreElements(); boolean hasMoreTokens(); String nextToken(); Object nextElement();
        String in = "1=Hello;2=Always;3=Kitchen;";
        stringTokenizer = new StringTokenizer(in, "=;"); //выделить из источника блоки, используя разделители =;
        while (stringTokenizer.hasMoreTokens()) {
            String key = stringTokenizer.nextToken();
            String value = stringTokenizer.nextToken();
            System.out.println("key=" + key + "\tvalue=" + value); //key=1	value=Hello key=2	value=Always key=3	value=Kitchen
        }

        BitSet bitSet; //BitSet implements Cloneable, Serializable //создает специальный типа массива, который хранит битовые значения в форме boolean значений

        Optional optional; //class Optional<T> //OptionalDouble, OptionalInt, OptionalLong
        optional = Optional.empty();
        if (!optional.isPresent()) {
            System.out.println("No value in optional"); //No value in optional
            System.out.println(optional.orElse("Set this if no")); //Set this if no
        }
        optional = Optional.of("Hello");
        if (optional.isPresent())
            System.out.println("Have value in optional: " + optional); //Have value in optional: Optional[Hello]

        Date date = new Date(500000); //class Date implements Serializable, Cloneable, Comparable<Date>
        //public boolean before(Date when); public boolean after(Date when);
        //long getTime(); void setTime(long time);
        //Instant toInstant(); static Date from(Instant instant);
        date = new Date();
        System.out.println(date); //Tue Nov 16 21:18:59 MSK 2021
        System.out.println("Time from 1 Jan 1970 in ms:" + date.getTime()); //Time from 1 Jan 1970 in ms:1637086739220

        Calendar calendar; //abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar>
        //void clear(int field);
        //void set(int field, int value);
        //void setTime(Date date);
        //boolean after(Object when);
        //boolean before(Object when);
        //boolean isSet(int field);
        //int get(int field);
        //Date getTime();
        //static Calendar getInstance();
        //abstract void add(int var1, int var2);
        calendar = Calendar.getInstance();
        System.out.println("YEAR=" + calendar.get(Calendar.YEAR)); //YEAR=2021
        System.out.println("MONTH=" + calendar.get(Calendar.MONTH)); //MONTH=10
        System.out.println("DATE=" + calendar.get(Calendar.DATE)); //DATE=16
        System.out.println("HOUR=" + calendar.get(Calendar.HOUR_OF_DAY)); //HOUR=21
        System.out.println("MINUTE=" + calendar.get(Calendar.MINUTE)); //MINUTE=19
        System.out.println("SECOND=" + calendar.get(Calendar.SECOND)); //SECOND=57
        calendar.set(Calendar.YEAR, 2025);
        System.out.println("YEAR UPDATE=" + calendar.get(Calendar.YEAR)); //YEAR UPDATE=2025

        GregorianCalendar gregorianCalendar = new GregorianCalendar(); //class GregorianCalendar extends Calendar
        //GregorianCalendar(int year, int month, int dayOfMonth);
        //GregorianCalendar(int year, int month, int dayOfMonth, int hours, int minutes);
        //GregorianCalendar(int year, int month, int dayOfMonth, int hours, int minutes, int seconds);
        //GregorianCalendar(Locale locale);
        //GregorianCalendar(TimeZone timeZone);
        //GregorianCalendar(TimeZone timeZone, Locale locale);
        if (!gregorianCalendar.isLeapYear(gregorianCalendar.get(Calendar.YEAR)))
            System.out.println("This year is not leap"); //This year is not leap

        TimeZone timeZone; //abstract class TimeZone implements Serializable, Cloneable
        //static void setDefault(TimeZone zone);
        //static TimeZone getDefault();
        //static TimeZone getTimeZone(ZoneId zoneId);

        SimpleTimeZone simpleTimeZone; //class SimpleTimeZone extends TimeZone
        //SimpleTimeZone(int timeDelta, String tzName)

        Locale locale; //class Locale implements Cloneable, Serializable //Calendar, GregorianCalendar, DateFormat and SimpleDateFormat use Locale
        //Locale(String language); Locale(String language, String country); Locale(String language, String country, String variant);
        //String getDisplayName();
        //String getDisplayCountry();
        //String getDisplayLanguage();
        //static void setDefault(Locale localeObj);
        //static Locale getDefault();

        Random random; //class Random implements Serializable
        //Random(); Random(long seed)
        //void nextBytes(byte[] bytes)
        //boolean nextBoolean();
        //int nextInt();
        //int nextInt(int bound);
        //long nextLong();
        //double nextDouble();
        //double nextGaussian();
        //float nextFloat();
        //IntStream ints();
        //LongStream longs();
        //DoubleStream doubles();

        TimerTask timerTask; //abstract class TimerTask implements Runnable
        //boolean cancel();
        //long scheduledExecutionTime();
        //abstract void run();
        Timer timer; //class Timer
        //Timer(); Timer(boolean DThread); Timer(String tName); Timer(String tName, boolean DThread);
        //void cancel();
        //void schedule(TimerTask task, long delay);
        //void schedule(TimerTask task, Date time);
        //void schedule(TimerTask task, long delay, long period);
        //void schedule(TimerTask task, Date firstTime, long period);
        //void scheduleAtFixedRate(TimerTask task, long delay, long period);
        //void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
        //int purge();
        var myTimerTask = new MyTimerTask();
        timer = new Timer();
        System.out.println("Start:" + new Date()); //Start:Tue Nov 16 21:20:55 MSK 2021
        timer.schedule(myTimerTask, 1000, 500); //изначально задержка 1000мс, потом повтор каждые 500мс //Tue Nov 16 21:20:58 MSK 2021...
        Thread.sleep(5000); //усыпить главный поток
        timer.cancel(); //завершить работу таймера
        System.out.println("Stop:" + new Date()); //Stop:Tue Nov 16 21:21:10 MSK 2021

        Currency currency; //class Currency implements Serializable
        currency = Currency.getInstance(Locale.JAPAN);
        System.out.println("CurrencyCode=" + currency.getCurrencyCode() + ", Symbol=" + currency.getSymbol() + ", DisplayName=" + currency.getDisplayName()); //CurrencyCode=JPY, Symbol=¥, DisplayName=японская иена

        Formatter formatter; //class Formatter implements Closeable, Flushable
        //Formatter(); Formatter(Appendable buf); Formatter(Appendable buf, Locale loc); Formatter(String filename); Formatter(File outF); Formatter(OutputStream outStrm); Formatter(String filename, String charset);
        //void close();
        //void flush();
        //Formatter format(String format, Object... args)
        formatter = new Formatter();
        formatter.format("Her name is %s. She is %d years old. Her weight is %f.", "Jane", 32, 45.7);
        System.out.println(formatter); //Her name is Jane. She is 32 years old. Her weight is 45,700000.
        formatter.close(); //or use try
        System.out.printf("Her name is %s. She is %d years old. Her weight is %f.", "Jane", 32, 45.7); //можно так, даже проще //Her name is Jane. She is 32 years old. Her weight is 45,700000.

        Scanner scanner1; //class Scanner implements Iterator<String>, Closeable
        //Scanner(Readable source);...
        //boolean hasNext();... String next();...
        FileReader fileReader = new FileReader("src/chapter20/MoreUtilityClasses/in");
        try (Scanner scanner = new Scanner(fileReader)) { //System.in //или scanner.close(); в конце, если не использовать try
            scanner.useDelimiter(" ");
            scanner.findInLine("PatternFind");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt())
                    System.out.println("You enter int " + scanner.nextInt()); //You enter int 1, 2, 3, 4, 56, 78, 332
                else if (scanner.hasNextDouble())
                    System.out.println("You enter double " + scanner.nextDouble()); //You enter double 91.111, 65.8
                else if (scanner.hasNextBoolean())
                    System.out.println("You enter boolean " + scanner.nextBoolean()); //You enter boolean true, false
                else {
                    String string = scanner.next();
                    System.out.println("You enter string " + string); //You enter string Hello, World, end
                    if (string.equals("end"))
                        break;
                }
            }
        }

        ResourceBundle resourceBundle; //abstract class ResourceBundle
        ListResourceBundle listResourceBundle; //abstract class ListResourceBundle extends ResourceBundle
        PropertyResourceBundle propertyResourceBundle; //class PropertyResourceBundle extends ResourceBundle
    }
}