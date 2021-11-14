package chapter17.StringHandling;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String s = new String(); //(char chars[]), (char chars[], int startIndex, int numChars),
        //(byte chrs[]), (byte chrs[], int startIndex, int numChars)
        //(String strObj)
        //(int codePoints[], int startIndex, int numChars)

        s = "Hello World"; //можно сразу строку присвоить
        System.out.println(s.length()); //длина строки //11
        System.out.println(s + " Hola mundo " + s); //соединение строк //Hello World Hola mundo Hello World
        System.out.println(s + 9 + 1 + " one"); //соединение строк и чисел //Hello World91 one
        System.out.println(s.charAt(4)); //o

        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        s.getChars(1, 4, chars, 1); //в chars сохранить данные с s, начиная с 1 и заканчивая 4-1
        System.out.println(chars); //aelle
        byte bytes[] = s.getBytes(); //получить массив byte из строки
        for (byte aByte : bytes)
            System.out.print(aByte + ", "); //72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100,
        char charArrey[] = s.toCharArray(); //получить массив char из строки
        for (char aChar : charArrey)
            System.out.print(aChar + ", "); //H, e, l, l, o,  , W, o, r, l, d,

        System.out.println(s.equals("Hello")); //стока равна "Hello"? //false
        System.out.println(s.equalsIgnoreCase("Hello")); //стока равна "Hello" без учета регистров? //false
        System.out.println(s.regionMatches(0, "Hello", 0, 5)); //есть ли совпадение с учетом начала и длины? //true
        System.out.println(s.regionMatches(true, 0, "HELLO", 0, 5)); //есть ли совпадение с учетом начала и длины и без учета регистров? //true
        System.out.println(s.startsWith("Hel")); //начинается на "Hel" //true
        System.out.println(s.startsWith("ello", 1)); //начинается на "ello" со сдвигом 1 //true
        System.out.println(s.endsWith("rld")); //заканчиваеится на "rld" //true
        String s1 = new String(s);
        String s2 = s;
        String s3 = new String(s).intern(); //не создавать новую строку, а получить ссылку в пуле на уже имеющуюся
        System.out.println(s == s1); //== для строк - указывает на один и тот же объект //false
        System.out.println(s == s2); //true
        System.out.println(s3 == s); //true
        System.out.println(s3 == s1); //false
        System.out.println(s3 == s2); //true
        System.out.println(s.compareTo("ABC")); //сравнение строк, если >0, то s больше "ABC" //7
        System.out.println(s.compareTo("abc")); //-25
        System.out.println(s.compareToIgnoreCase("hello world!")); //срвнение без учета регистра //-1
        System.out.println(s.compareToIgnoreCase("hello worl")); //1
        System.out.println(s.indexOf("l")); //индекс первого совпадения "l" в строке, если нет - -1 //2
        System.out.println(s.indexOf("z")); //-1
        System.out.println(s.indexOf("l", 5)); //индекс первого совпадения, начиная с 5 позиции //9
        System.out.println(s.lastIndexOf("l")); //индекс последнего совпадения "l" в строке //9
        System.out.println(s.lastIndexOf("l", 5)); //индекс последнего совпадения, начиная с 5 позиции //3
        System.out.println(s.substring(6)); //вернуть строку с 6 символа и до конца //World
        System.out.println(s.substring(6, 9)); //вернуть строку с 6 символа и до 9-1 символа //Wor
        System.out.println(s.concat("Add").concat("New")); //добавление к строке новых строк //Hello WorldAddNew
        System.out.println(s.replace('l', 'L')); //заменить 'l' на 'L' //HeLLo WorLd
        String sWithSpaces = "   " + s + "   "; //добаляем пробелы в начало и конец строки
        System.out.println(sWithSpaces.trim()); //обрезать пробелы в начале и конце строки //Hello World
        System.out.println(sWithSpaces.strip()); //обрезать пустое пространство в начале и конце строки, появилось в 11 Java
        System.out.println(sWithSpaces.stripLeading() + "."); //обрезать пустое пространство в начале строки, появилось в 11 Java //Hello World   .
        System.out.println(sWithSpaces.stripTrailing() + "."); //обрезать пустое пространство в конце строки, появилось в 11 Java //   Hello World.
        System.out.println(String.valueOf(new Box(4, 6, 77))); //аналог toString() //Dimension: a=4, b=6, c=77
        System.out.println(new Box(10, 20, 30)); //Dimension: a=10, b=20, c=30
        System.out.println(String.valueOf(58.59)); //58.59
        System.out.println(String.valueOf(charArrey, 1, 4)); //получить строку из charArrey с началом от 1 символа и длиной 4 символа //ello
        System.out.println(s.toLowerCase()); //строка в нижнем регистре //hello world
        System.out.println(s.toUpperCase()); //строка в верхнем регистре //HELLO WORLD
        System.out.println(String.join(", ", s, "one", "two")); //соединить строки, применив разделитель //Hello World, one, two
        System.out.println(s.isEmpty()); //строка пустая //false
        Stream<String> stream = s.lines(); //получить строковый поток, появилось в 11 Java
        System.out.println(s.matches("ello")); //строка соответствует шаблону //false
        System.out.println(s.replaceFirst("l", "NEW")); //заменить первое совпадение "l" на "NEW" //HeNEWlo World
        System.out.println(s.replaceAll("l", "NEW")); //заменить все совпадения "l" на "NEW" //HeNEWNEWo WorNEWd
        String[] spl = s.split("l"); //разделить на массив строк по шаблону
        for (String s4 : spl)
            System.out.print(s4 + ", "); //He, , o Wor, d,
        String[] spl2 = s.split("l", 3); //разделить на массив строк по шаблону, лимит 3 элемента, в последний войдет все оставшееся
        for (String s4 : spl2)
            System.out.print(s4 + ", "); //He, , o World,
        System.out.println(s.subSequence(4, 9)); //аналог substring - вернуть строку с 4 символа и до 9-1 символа//o Wor

        StringBuffer sb = new StringBuffer("Hello"); //аналог String, только если String неизменная, то StringBuffer изменяется
        //() - reserves room for 16 characters without reallocation
        //(int size) - accepts an integer argument that explicitly sets the size of the buffer
        //(String str) - reserves room for 16 more characters without reallocation
        //(CharSequence chars) - like above
        System.out.println(sb.length()); //длина строки //5
        System.out.println(sb.capacity()); //емкость //21
        sb.ensureCapacity(50); //задать самостоятельно емкость
        System.out.println(sb.capacity()); //50
        System.out.println(sb.charAt(1)); //символ по позиции 1 //e
        sb.setCharAt(1, 'o'); //установить в символ по позиции 1 значение 'o'
        sb.setLength(4); //установить длину 4
        System.out.println(sb); //Holl
//        getChars(int sourceStart, int sourceEnd, char target[], int targetStart); like String
        System.out.println(sb.append(1).append("End")); //добавить в конец строки //Holl1End
        System.out.println(sb.insert(1, "New")); //вставить на 1 позицию "New" //HNewoll1End
        System.out.println(sb.reverse()); //перевернуть строку //dnE1lloweNH
        System.out.println(sb.delete(3, 5)); //удалить символы с 3 по 5 //dnEloweNH
        System.out.println(sb.deleteCharAt(2)); //удалить символ на позиции 2 //dnloweNH
        System.out.println(sb.replace(2, 6, "CAT")); //заменить символы с 2 по 6 значением "CAT" //dnCATNH
        System.out.println(sb.substring(3)); //обрезать строку с позиции 3 и бдо конца, возвращает String //ATNH
        System.out.println(sb.substring(2, 5)); //вернуть строку со 2 символа и до 5-1 символа, возвращает String //CAT
        System.out.println(sb.capacity()); //50
        sb.trimToSize(); //уменьшить емкость до размера хранимой строки
        System.out.println(sb.capacity()); //7

        var sbl = new StringBuilder(); //аналогично StringBuffer, но не синхронизированная, поэтому работает быстрее
    }
}

