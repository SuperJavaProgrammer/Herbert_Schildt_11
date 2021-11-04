package chapter6.IntroducingClasses;

public class Animal { //класс
    int speed; //переменные класса
    int weight;

    Animal() { //конструктор без параметров для создания объекта класса
        speed = 10;
        weight = 10;
    }

    Animal(int speed, int weight) { //конструктор с 2 параметрами
        this.speed = speed;
        this.weight = weight;
    }

    int dist(int h){ //метод класса, принимает 1 параметр, возвращает int
        System.out.println("Total in " + h + " hours = " + h * speed);
        return h * speed; //возврат резуотата метода
    }

    void mas(){ //метод ничего не возвращает
        if (weight > 70) System.out.println("Ты не сможешь поднять");
        else System.out.println("Ты сможешь поднять");
    }

}
