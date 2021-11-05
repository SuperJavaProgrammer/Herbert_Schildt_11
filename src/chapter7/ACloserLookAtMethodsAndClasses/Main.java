package chapter7.ACloserLookAtMethodsAndClasses;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) //вывести аргументы командной строки
            System.out.println(i + "=" + args[i]);

        var panda = new Animal(20,90); //Static block 0
            panda.mas(); //проверка перегрузки методов //Ты не сможешь поднять
            panda.mas(40); //Ты не сможешь поднять, ты слабый
        System.out.println("Panda=" + panda.dist()); //Total in 24 hours = 480 Panda=480
        System.out.println("Panda=" + panda.dist(3)); //Total in 3 hours = 60 Panda=60

        var panda1 = new Animal(20);
        var panda2 = new Animal(30.5);
        var panda3 = panda1.createSmaller(); //вызов нестатического метода для объекта класса
        var panda4 = Animal.createBigger(panda2); //вызов статического метода для класса
        var panda5 = Animal.change(panda2); //передача аргументов по ссылке/значению

        Animal.addTotal(0, panda1, panda2, panda3, panda4, panda5); //аргументы переменной длины, от 0 до N //Всего животных:5
    }
}
