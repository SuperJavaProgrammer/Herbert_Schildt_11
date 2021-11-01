package chapter3.DataTypesVariablesAndArrays;

public class Main {

    public static void main(String[] args) {
        byte b2 = 0b1101010; //0b – 2-ая система счисления, 1 byte -128 - 127
        short s8 = 012347; //0 – 8-ая система счисления, 2 bytes -32768 - 32767
        int i16 = 0xabcdef09; //0x - 16-ая система счисления, 4 bytes -2147483648 +2147483647
        long l_ = 1_234_567__890; //_ - для удобного выделения, 8 bytes -9223372036854775808 +9223372036854775807
        long l = 100L; //l
        float f = 6.022E23f; //F явно указать, 4 bytes 1.4е-045 3.4е+038
        double d = 6.022E23d; //D явно указать, 8 bytes 4.9е-324 1.8е+308
        double d16 = 0x12.2P2; //Р2 для указания 16-ого числа с плавающей точкой, Р2 - двоичный порядок, обозначает степень числа два, на которое умножается заданное число. 72,5
        char cchar = 'c'; //2 bytes, 0 - 65,535
        char cint = 100; //можно хранить числа
        cint += cchar;
        char c8 = '\100'; //8-ый символ
        char c16 = '\udada'; //16-ый символ
        boolean b = false; //true
        String stringLiteral = "Hello World";
        var cool1 = 10.0; //универсальная переменная, определяется по присваиваемому значению
        var cool2 = "VivaLaVida";
        var cool3 = 42;
        var coolArray = new int[10];
//        var coolArrayError = { 1, 2, 3 }; // Wrong

        double l1 = b2 - s8 * i16 + l_ + d;	//динамическая инициализация, продвижение типов
        byte bbyte = (byte) l1; //приведение типов

        int ma[] = new int[10];	//объявление массивов, выделить память для 10 элементов
        int ma2[] = {2, 3, 4}; //сразу установить элементы в массиве
        ma[3] = 5; //присвоение значений элементам массива по индексу
        ma[0] = 10;

        System.out.println("16-ая система: 0xabcdef=" + i16); //-1412567287
        System.out.println("8-ая система: 01234567=" + s8); //5351
        System.out.println("2-ая система: 0b10101010=" + b2); //106
        System.out.println("1_234_567__890=" + l_); //1234567890
        System.out.println("8-ый символ: \100 = " + c8); //@
        System.out.println("16-ый символ в Юникоде: \udada = " + c16); //?
        System.out.println("Особые знаки \'\t\f\"\"\b\\\n\t\ta\ra "); //'	"\
        System.out.println("100 + c =" + cint); //Ç
        System.out.println("Приведение типов " + bbyte);  //-1
        System.out.println("boolean = " + b + !b); //falsetrue
        System.out.println("Работа с массивами " + ma2[2] + " " + ma[1] + " длина=" + ma2.length); //4 0 длина=3
        System.out.println("Первая программа: " + stringLiteral); //Hello World
        System.out.println("Обобщенный тип: " + cool1 + cool2 + cool3 + coolArray[5]); //10.0VivaLaVida420
    }
}
