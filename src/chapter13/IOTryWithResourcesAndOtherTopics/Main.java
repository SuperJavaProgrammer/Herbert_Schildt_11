package chapter13.IOTryWithResourcesAndOtherTopics;

import java.io.*;

import static java.lang.Math.*; //use short form sqrt, pow and other instead of Math.sqrt
import static java.lang.System.out; //now can use out.println

public class Main {
    transient int tr; //not persist when an object is stored
    volatile int vol; //compiler must always use the master copy of a volatile variable

    public strictfp static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //буфферизированный поток ввода (с клавиатуры)
        String brString = br.readLine(); //читать строку
        System.out.println("Вы ввели:" + brString); //Вы ввели:ABCDEFG
        int brInt = br.read(); //читать только первый int/char
        System.out.write(brInt); //не вывело на консоль
        char c = (char) brInt;
        PrintWriter pw = new PrintWriter(System.out, true); //поток вывода
        pw.println("brInt=" + brInt + " c=" + c + " brString=" + brString); //brInt=83 c=S brString=ABCDEFG

        try(var fin = new FileInputStream("src/chapter13/IOTryWithResourcesAndOtherTopics/in");
            var fout = new FileOutputStream("src/chapter13/IOTryWithResourcesAndOtherTopics/out")) { //try с ресурсами. По завершунию ресурсы автоматически закрываются. AutoCloseable
//            1 2 3 4 Hello 56 78 World 91,111 true false 332 65,8 end //in
//            2!3!4!5!Ifmmp!67!89!Xpsme!:2-222!usvf!gbmtf!443!76-9!foe //out
            int i;
            do {
                i = fin.read(); //читать данные
                if (i != -1) //если не конец файла
                    fout.write(i + 1); //записать прочитанное значение со сдвигом на 1
            } while (i != -1);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        A a = new A();
        B b = new B();
        out.println("a instanceof A " + (a instanceof A)); //a относится к классу A или его потомок //true
        out.println("a instanceof B " + (a instanceof B)); //false
        out.println("b instanceof A " + (b instanceof A)); //true
        a = b;
        out.println("a instanceof B " + (a instanceof B)); //true

        //java -ea AssertDemo to use. Else skip! Для тестирования
        assert 2 > 1; //если истина - продолжать дальше
        assert 3 > 5; //если ложь - AssertionError
        assert 3 > 4 : a; //return a in description

        out.println("Hyp=" + sqrt(pow(3, 2) + pow(4, 2))); //использование статического импорта //Hyp=5.0
    }

}

