package chapter4.Operators;

public class Main {

    public static void main(String[] args) {
        var a = 1 + 4 * 3 / 2 % 5; //арифметические операции
        System.out.println(a); //2
        int b = a++; //сперва b=a, потом a=a+1
        System.out.println(b + " " + a); //2 3
        b += ++a; //сперва a=a+1, потом b=b+a
        System.out.println(b + " " + a); //6 4
        b--;
        System.out.println(b); //5
        --b;
        System.out.println(b); //4
        b += 5; //b = b + 5
        b -= 3;
        b *= 4;
        b /= 2;
        System.out.println(b); //12
        b %= 7; //% - остаток от деления
        System.out.println(b); //5

        a = ~10 & 5 | 7 ^ 6; //бинарные операции Не, И, Или, Исключающее И
        System.out.println(a); //5
        b <<= 5; //сдвиг влево на 5 знаков
        System.out.println(b); //160
        b >>= 2; //сдвиг вправо на 2 знака
        System.out.println(b); //40
        b >>>= 2; //беззнаковый сдвиг вправо на 2 знака
        System.out.println(b); //10
        b ^= 3;
        System.out.println(b); //9: 1010 XOR 0011 = 0110

        var c = 5 > 3; //в с хранится логический результат
        System.out.println(c); //true
        System.out.println((7 < 9) + " " + (2 == 4) + " " + (1 != 4) + " " + (3 >= 2) + " " + (8 <= 1)); //true false true true false

        var d = false;
        System.out.println(c & d); //false, логическая операция И
        System.out.println(c && d); //false, укороченная логическая операция И, если с false, то результат false, d не проверяется
        System.out.println(c | d); //true, логическая операция Или
        System.out.println(c || d); //true, укороченная логическая операция Или
        System.out.println(!c); //false, логическая операция Не
        c &= d;
        c |= d;
        c ^= d;
        System.out.println(c); //false
        System.out.println(10 < 5 ? 10 : 5); //5, тернерная операция. Если 10 < 5 истина, то результат 10, иначе 5

        int p1, p2, p3; //объявление переменных
        p1 = p2 = p3 = 42; //присвоение всем переменным одного значения
        System.out.println("" + p1 + p2 + p3); //424242
        //приоритет операций:
        // 1) ()
        // 2) ++ (постфиксная операция), -- (постфиксная операция)
        // 3) ++ (префиксная операция), -- (префиксная операция), ~, !, +(унарная операция), -(унарная операция), приведение типов
        // 4) *, /, %
        // 5) +, -
        // 6) >>, >>>, <<
        // 7) >, >=, <, <=, instanceof
        // 8) ==, !=
        // 9) &
        // 10) ^
        // 11) |
        // 12) &&
        // 13) ||
        // 14) ? :
        // 15) ->
        // 16) =
    }
}
