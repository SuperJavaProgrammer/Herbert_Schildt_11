package chapter5.ControlStatements;

public class Main {

    public static void main(String[] args) {
        var a = 5;
        var b = 10;
        var c = 20;
        System.out.println("a, b, c = " + a + b + c); //a, b, c = 51020
        if (a > b) { //если a > b, то выполняем блок
            System.out.println("a > b");
            if (a > 2 * b)
                System.out.println("a > 2 * b");
            else //иначе, относится к последнему if
                System.out.println("a <= 2 * b");
        }
        else if (a > c) //иначе если
            System.out.println("a > c");
        else
            System.out.println("a < b < c"); //a < b < c

        switch (a) { //множественный выбор из разных вариантов
            case 1: //если в a значение 1
                System.out.println("1");
                break; //выйти из switch
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3"); //выходить не надо, продолжаем дальше
            case 4:
                System.out.println("4");
            case 5:
                System.out.println("5"); //5
            case 6:
            case 7:
                System.out.println("6-7"); //6-7
            default: //если был какой-то другой вариант
                System.out.println("not 1-5");
        }

        while (a < ++b) { //пока a < ++b истинно, делаем блок
            System.out.println("" + a + b);
            a += 2;
        }

        do { //делаем хотя бы один раз
            System.out.println(c);
        } while (c-- > 0); //пока условие истинно

        for (int i = 0, j = 100; i < 10; i++, j--) { //инициализация; условие для выхода; итерация
            System.out.println("" + i + j);
        }
        for (; a < 30;) { //некоторые части могут отсутствовать
            System.out.println(a);
            a++;
        }
        for (; ;) { //или все
            System.out.println(a);
            a++;
            if (a == 100) break;
        }

        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int sum = 0;
        label: //метка для выхода
        for (int i = 0; i < 5; i++) {
            for(var x: nums) { //для всех nums делаем...
                if (x % 2 == 0) continue; //пропустить следующие действия в цикле
                if (x == 5) continue label; //пропустить следующие действия после метки
                if (x == 7) break; //выйти из внутреннего цикла
                if (x == 9) break label; //выйти к концу метки
                sum += x;
                System.out.print("i=" + i + ",x=" + x + ",s=" + sum + " "); //i=0,x=1,s=1 i=0,x=3,s=4 i=1,x=1,s=5 i=1,x=3,s=8 i=2,x=1,s=9 i=2,x=3,s=12 i=3,x=1,s=13 i=3,x=3,s=16 i=4,x=1,s=17 i=4,x=3,s=20
            }
        }

        if (10 == 10) return; //выход, возврат из программы
        System.out.println("You'll never see it");
    }
}
