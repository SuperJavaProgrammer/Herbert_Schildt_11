package chapter15.LambdaExpressions;

import java.util.function.*;

public class Main {
    public strictfp static void main(String[] args) throws Exception {
        FuncInt fi = () -> 10; //функциональному интерфейсу(ФИ) присваивается лямбда-выражение(ЛВ), реализует метод интерфейса
        System.out.println(fi.getNum()); //получить результат ЛВ //10
        fi = () -> (int) (Math.random() * 100); //присваиванием другого ЛВ
        System.out.println(fi.getNum()); //83

        FuncIntParam fip = (n) -> n % 100; //ЛВ реализует метод ФИ с 1 параметром
        System.out.println(fip.getNum(685)); //85
        fip = n -> n * n; //использовать n вместо (n) для 1 параметра
        System.out.println(fip.getNum(9)); //81

        FuncInt2Param fi2p = (n1, n2) -> "" + n1 + n2; //реализует метод ФИ с 2 параметрами
        System.out.println(fi2p.getNum(100, "500")); //100500
        fi2p = (n1, n2) -> { //блочное ЛВ
            String result = "";
            for (int i = 0; i < n1; i++)
                result += n2 + ", ";
            return result; //должно возвращать результат
        };
        System.out.println(fi2p.getNum(5, "Hello World")); //Hello World, Hello World, Hello World, Hello World, Hello World,

        FuncIntGeneric<Integer> fig1 = n -> n % 100; //применение ЛВ для обобщенного ФИ
        System.out.println(fig1.getNum(777)); //77
        FuncIntGeneric<String> fig2 = n -> n + "-" + n;
        System.out.println(fig2.getNum("Hello")); //Hello-Hello

        Constr.test(n -> n % 5, 53); //метод принимаеи ФИ в качестве параметра, можно передать ЛВ //3
        Constr.test(n -> n * 2, 11); //22

//        int fin = 10;
//        FuncInt fi3 = () -> { fin = 100; return fin; }; //переменная в ЛВ должна быть финальной, ее нельзя менять внутри ЛВ

        Constr.test(Constr::test1, 500); //ссылка на статический метод test1, поскольку он совместим с ФИ //super::name //MyArrayOps::<Integer>countMatching //5000
        Constr constr = new Constr();
        Constr.test(constr::test2, 2000); //ссылка на нестатический метод test2, поскольку он совместим с ФИ //typeName.super::name //40000

        FuncIntConstructor funcIntConstructor = Constr::new; //создание Constr через использование ссылки на конструктор //MyClass[]::new;
        Constr constr1 = funcIntConstructor.getConstr(10);
        constr1.getI(); //i=10 i1=0

        UnaryOperator<String> uo; //Имеющиеся ФИ
        BinaryOperator<String> bo;
        Consumer<String> c;
        Supplier<String> s;
        Predicate<String> p;
        Function<Integer, String> f = (a) -> "String=" + a; //применение готового ФИ
        System.out.println(f.apply(585)); //String=585
    }

}

