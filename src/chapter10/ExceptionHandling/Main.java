package chapter10.ExceptionHandling;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random(); //для работы со случайными числами
        for(int i = 0; i < 10; i++) {
            try { //проверить блок кода на исключения
                int c = 100 / r.nextInt(4); //может быть деление на 0, если сгенерируется 0
                System.out.println("No exception " + c);
            } catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {	//поймать 2 тпа исключений: арифметическое или выход за пределы массива
                System.out.println("ArithmeticException! " + e); //действия после поимки исключения //ArithmeticException! java.lang.ArithmeticException: / by zero
//                return; //finally все равно выполнится
//                System.exit(0); //finally не выполнится
            } catch(Exception e) {	//множественый перехват, поймать остальные исключения
                System.out.println("Exception! " + e);
            }
            finally { //финальный оператор, выполняется всегда (кроме System.exit())
                System.out.println("After all");
            }
        }
        try {
            A.ex();	//вызвать метод, создающий исключение
        } catch(Exception e){ //и поймать его
            System.out.println("Ex=" + e + " Причина=" + e.getCause() + " Сообщение=" + e.getMessage()); //Ex=java.lang.NullPointerException: дeмoнcтpaция Причина=java.lang.ArrayIndexOutOfBoundsException: вышли за пределы массива Сообщение=дeмoнcтpaция
            System.out.println("Стектрейс:");
            e.printStackTrace();
//            java.lang.NullPointerException: дeмoнcтpaция
//                  at chapter10.ExceptionHandling.A.ex(A.java:6)
//                  at chapter10.ExceptionHandling.Main.main(Main.java:23)
//            Caused by: java.lang.ArrayIndexOutOfBoundsException: вышли за пределы массива
//                  at chapter10.ExceptionHandling.A.ex(A.java:7)
//	                ... 1 more
        }
    }

}
