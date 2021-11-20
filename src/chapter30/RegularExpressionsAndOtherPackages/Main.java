package chapter30.RegularExpressionsAndOtherPackages;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Pattern pattern; //class Pattern implements Serializable
        //static Pattern compile(String pattern);
        //Matcher matcher(CharSequence str)
        Matcher matcher; //class Matcher implements MatchResult
        //boolean matches();
        //boolean find();
        //int start();
        //int end();
        //String group();
        //String replaceAll(String newStr);
        //"xy", [wxyz], [^wxyz], [1-9], "x.", "x+", "x*", "x?"

        boolean matches; //флаг - нашлось ли совпадение
        pattern = Pattern.compile("Java"); //задаем шаблон
        matcher = pattern.matcher("Java"); //задаем строку для поиска по шаблону
        matches = matcher.matches(); //есть совпадение?
        System.out.println(matches ? "Matches" : "No Match"); //Matches
        matcher = pattern.matcher("Java FX is good Java type");
        matches = matcher.matches();
        System.out.println(matches ? "Matches" : "No Match"); //No Match
        while (matcher.find()) //пока есть совпадения
            System.out.println("Find in index " + matcher.start()); //Find in index 0, 16

        pattern = Pattern.compile("W+");
        matcher = pattern.matcher("W WNNW WW WWW");
        while (matcher.find())
            System.out.println("Find in index " + matcher.start() + " value " + matcher.group()); //Find in index 0 value W, 2 - W, 5 - W, 7 - WW, 10 - WWW

        pattern = Pattern.compile("e.+d"); //start with e, end with d, the longest match
        matcher = pattern.matcher("end weeduy new done");
        while (matcher.find())
            System.out.println("Find in index " + matcher.start() + " value " + matcher.group()); //Find in index 0 value end weeduy new d

        pattern = Pattern.compile("e.+?d"); //start with e, end with d, small matches
        matcher = pattern.matcher("end weeduy new done");
        while (matcher.find())
            System.out.println("Find in index " + matcher.start() + " value " + matcher.group()); //0 - end, 5 - eed, 12 - ew d

        pattern = Pattern.compile("e.?+d"); //start with e, end with d, small matches
        matcher = pattern.matcher("end weeduy new done");
        while (matcher.find())
            System.out.println("Find in index " + matcher.start() + " value " + matcher.group()); //0 - end, 5 - eed

        pattern = Pattern.compile("[a-z]+"); //start with e, end with d, small matches
        matcher = pattern.matcher("end we!eduy! new done");
        while (matcher.find())
            System.out.println("Find in index " + matcher.start() + " value " + matcher.group()); //0 - end, 4 - we, 7 - eduy, 13 - new, 17 - done

        pattern = Pattern.compile("Jon.*? "); //begins with Jon followed by zero or more characters, ending in a space
        matcher = pattern.matcher("Jon Jonathan Frank Ken Todd Jonny ");
        String result = matcher.replaceAll("Eric "); //заменить все совпадения
        System.out.println("Modified: " + result); //Modified: Eric Eric Frank Ken Todd Eric

        pattern = Pattern.compile("[ ,.!]"); // ,.!
        String[] split = pattern.split("one two,three four!five.six"); //разделить на элементы строку по шаблону
        for (String s : split)
            System.out.print(s + "+"); //one+two+three+four+five+six+

        System.out.println(Pattern.matches("Jon.*? ", "Jon Jonathan Frank Ken Todd Jonny ")); //если надо за один раз проверить соответствие шаблону, чтобы не создавать pattern и matcher //true
        System.out.println("Jon Jonathan Frank Ken Todd Jonny ".matches("Jon.*? ")); //или еще проще так //true


        String string = new String();
        Class<?> cl = string.getClass(); //Class<?> cl = Class.forName("java.lang.String"); //получить класс по его объекту
        System.out.println("\t\tConstructors");
        Constructor<?>[] constructors = cl.getConstructors(); //получить конструкторы
        for (Constructor<?> constructor : constructors)
            System.out.println(constructor + " "); //public java.lang.String(byte[]) ...
        System.out.println("\t\tFields");
        Field[] fields = cl.getDeclaredFields(); //получить поля
        for (Field field : fields) {
            System.out.println(field + " ");
            int modifier = field.getModifiers();
            if (Modifier.isFinal(modifier)) //финальные поля
                System.out.println("\tFINAL " + field.getName());
        }
        System.out.println("\t\tMethods");
        Method[] methods = cl.getMethods(); //получить методы
        for (Method method : methods) {
            System.out.println(method + " ");
            int modifier = method.getModifiers(); //модификаторы
            if (Modifier.isStatic(modifier))
                System.out.println("\tSTATIC " + method.getName());
        }

        Date date = new Date();
        DateFormat df; //abstract class DateFormat extends Format //для форматирования вида даты
        System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(date)); //20.11.2021
        System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(date)); //20 нояб. 2021 г. //like default
        System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(date)); //20 ноября 2021 г.
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(date)); //суббота, 20 ноября 2021 г.
        System.out.println(DateFormat.getTimeInstance(DateFormat.SHORT).format(date)); //22:38
        System.out.println(DateFormat.getTimeInstance(DateFormat.MEDIUM).format(date)); //22:38:35 //like default
        System.out.println(DateFormat.getTimeInstance(DateFormat.LONG).format(date)); //22:38:35 MSK
        System.out.println(DateFormat.getTimeInstance(DateFormat.FULL).format(date)); //22:38:35 Москва, стандартное время
        System.out.println(DateFormat.getDateTimeInstance().format(date)); //20 нояб. 2021 г., 22:38:35
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a zzz"); //class SimpleDateFormat extends DateFormat //конкретная реализация
        System.out.println(sdf.format(date)); //20 нояб. 2021 10:38:35 PM MSK

        LocalDate ld = LocalDate.now(); //другой класс для получения даты
        System.out.println(ld); //2021-11-20
        LocalTime lt = LocalTime.now(); //для получения времени
        System.out.println(lt); //22:40:27.942937700
        LocalDateTime ldt = LocalDateTime.now(); //для получения даты и времени
        System.out.println(ldt); //2021-11-20T22:40:35.715499300
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("d MMMM yyyy, hh:mm a"))); //20 ноября 2021, 10:40 PM
        int day = ldt.getDayOfMonth();
        int hour = ldt.getHour();
        int month = ldt.getMonth().getValue();
        System.out.println("day=" + day + ", hour=" + hour + ", month=" + month); //day=20, hour=22, month=11
        ldt = LocalDateTime.parse("25 октября 2020, 10:15 PM", DateTimeFormatter.ofPattern("d MMMM yyyy, hh:mm a"));
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("d MMMM yyyy, hh:mm a"))); //25 октября 2020, 10:15 PM
    }
}
