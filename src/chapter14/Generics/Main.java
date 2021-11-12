package chapter14.Generics;

public class Main {

    public strictfp static void main(String[] args) {
        Gen<Integer, String> isGen = new Gen<Integer, String>(100, "Hello"); //создание обобщенного класса с 2 обобщенными типами Integer, String. Полное объявление при создании
        isGen.show(); //T is type=java.lang.Integer Value=100 V is type=java.lang.String Value=Hello
        Gen<Long, String> liGen = new Gen<>(5000L, "100"); //создание этого же обобщенного класса с 2 другими обобщенными типами Long, String. Сокращенное объявление <> название при создании
        liGen.show(); //T is type=java.lang.Long Value=5000 V is type=java.lang.String Value=100

        Gen<Integer, String> isGenClone = new Gen<>(100, "Hello");
        isGenClone.same(isGen); //same
        isGenClone.same(liGen); //different

        Gen constr1 = new Gen(124L); //конструктор может принимать любой тик, относящийся к Number //java.lang.Long
        Gen constr2 = new Gen(124); //java.lang.Integer
        Gen constr3 = new Gen(124F); //java.lang.Float
        Gen constr4 = new Gen(124D); //java.lang.Double

        MinMaxImpl<Integer> minMax1 = new MinMaxImpl<>(15, 20);
        minMax1.min(); //определение min и max для разных типов //min=15
        minMax1.max(); //max=20
        MinMaxImpl<String> minMax2 = new MinMaxImpl<>("Hello", "World");
        minMax2.min(); //min=Hello
        minMax2.max(); //max=World

        MinMaxImpl minMax3 = new MinMaxImpl("Abc", "Xyz"); //raw type. Если не использовать типы, будет использоваться Object
        minMax3.min(); //min=Abc
        minMax3.max(); //max=Xyz
        String num1 = (String) minMax3.getNum1(); //Нужно выполнять преобразование типов. Могут возникать ошибки, если не получится привести к нужному типу
        System.out.println(num1); //Abc
        try {
            Integer num2 = (Integer) minMax3.getNum1();
            System.out.println(num2); //не дойдем сюда
        } catch (Exception e) {
            System.out.println("Не удалось выполнить преобразование типов"); //Не удалось выполнить преобразование типов
        }

        var minMax4 = new MinMaxImplSub<>(852L, 845L, "Hello World");
        System.out.println("getNum3=" + minMax4.getNum3() + " getNum2=" + minMax4.getNum1()); //getNum3=Hello World getNum2=852

        if (minMax1 instanceof MinMaxImpl<?>) //true
            System.out.println("minMax1 instanceof MinMaxImpl<?>");
        if (minMax3 instanceof MinMaxImpl<?>) //true
            System.out.println("minMax3 instanceof MinMaxImpl<?>");
        if (minMax1 instanceof MinMaxImplSub<?, ?>) //false
            System.out.println("minMax1 instanceof MinMaxImplSub<?, ?>");
        if (minMax4 instanceof MinMaxImpl<?>) //true
            System.out.println("minMax4 instanceof MinMaxImpl<?>");
        if (minMax4 instanceof MinMaxImplSub<?, ?>) //true
            System.out.println("minMax1 instanceof MinMaxImplSub<?, ?>");

//        Gen<Long, Long>[] arr = new Gen<>(1l, 1l)[10]; 5) нельзя создать массив с указанием конкретных типов из обобщенного класса
        MinMaxImpl<?>[] arr = new MinMaxImpl<?>[10]; //а так можно, если тип неизвестен
    }

}

