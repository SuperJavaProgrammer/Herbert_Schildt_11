package chapter12.EnumerationsAutoboxingAndAnnotations;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        City myCity = City.Moscow; //выбрать значение Moscow из перечисления City
        if (myCity == City.Moscow)
            System.out.println("I live in the capital " + myCity); //I live in the capital Moscow
        switch (myCity) { //применить перечисление со switch
            case Kiev:
                System.out.println("You choose Kiev");
                break;
            case New_York:
                System.out.println("You choose New-York");
                break;
            default:
                System.out.println("You don't choose Kiev and New-York"); //You don't choose Kiev and New-York
        }
        for (City city : City.values()) //перебор всех значений перечислений
            System.out.println("City=" + city + ". Country=" + city.getCountry() + ". Population=" + city.getPopulation() + ". Position=" + city.ordinal()); //ordinal() - позиция
//        City=Moscow. Country=Russia. Population=16. Position=0
//        City=Kiev. Country=Ukraine. Population=5. Position=1
//        City=New_York. Country=USA. Population=12. Position=2
//        City=London. Country=UK. Population=10. Position=3
//        City=Mars. Country=No Information. Population=0. Position=4
        System.out.println(City.valueOf("Kiev")); //значение по имени "Kiev", может возникнуть IllegalArgumentException: No enum constant
        System.out.println(City.Moscow.compareTo(City.Kiev)); //сравнить по порядку //-1
        System.out.println(City.London.compareTo(City.Kiev)); //2

        Character c1 = new Character('s'); //Классы-обертки для примитивных типов //deprecated
        Character c2 = 'i';
        char c = c1.charValue();
        Boolean b1 = new Boolean(true);
        Boolean b2 = Boolean.valueOf("tRuE"); //применять такой метод, чем устаревший вариант с конструктором
        Boolean b3 = Boolean.valueOf("NotTrue");
        System.out.println("" + b1 + b2 + b3); //truetruefalse
        Boolean b4 = false;
        boolean bl = b2.booleanValue();
        Number n; //Byte b; Short s; Integer i; Long l; Float f; Double d extends Number
        Double d1 = Double.valueOf("15.4"); //упаковка, может быть NumberFormatException, если формат неправильный
        double d = d1.doubleValue(); //распаковка
        Integer i1 = 100;
        int i = i1;
        Double a, b, cc; //правильно, но плохо так делать
        a = 10.0;
        b = 4.0;
        cc = Math.sqrt(a*a + b*b);
        System.out.println("Hypotenuse is " + cc); //Hypotenuse is 10.770329614269007

        System.out.println("Работа с аннотациями");
        AnnClass.noParam();
        AnnClass.haveParam("1", 1);
        AnnClass.twoAnn();
        AnnClass.markerAnn();
    }

}

