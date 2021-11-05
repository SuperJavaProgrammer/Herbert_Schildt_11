package chapter7.ACloserLookAtMethodsAndClasses;

public class Animal {
    int speed;
    double weight;
    static int total = 0; //статическая переменная, одна на весь класс
    final int constant = 100; //финальная переменная, менять нельзя

    static { //статический блок, выполняется 1 раз при обращении к классу
        System.out.println("Static block " + total);
    }

    Animal() {
        speed = 10;
        weight = 10;
    }

    Animal(int speed, double weight) { //перегрузка конструкторов
        this.speed = speed;
        this.weight = weight;
    }

    Animal(int speed) {
        this.speed = speed;
        this.weight = 10.0;
    }

    Animal(double weight) {
        this.speed = 10;
        this.weight = weight;
    }

    static int addTotal(int start, Animal ...animal) { //Метод может содержать и обычные параметры, но аргументы переменой длинны должны быть в конце. Аргументы переменной длины должны быть только одни
        total += animal.length + start;
        System.out.println("Всего животных:" + total);
        return total;
    }

    static Animal createBigger(Animal initial) { //статический метод, вызывается для класса, принимает объект и возвращает объект
        return new Animal(initial.speed + 1, initial.weight + 1);
    }

    static Animal change(Animal initial) {
        return new Animal(initial.speed * 2, initial.weight / 2);
    }

    Animal createSmaller() { //нестатический метод, вызывается для объекта класса
        return new Animal(speed - 1, weight - 1);
    }

    int dist(){
        System.out.println("Total in 24 hours = " + 24 * speed);
        return 24 * speed;
    }

    int dist(int h){ //перегрузка методов, имя такое же, но параметры отличаются
        System.out.println("Total in " + h + " hours = " + h * speed);
        return h * speed;
    }

    void mas(){
        if (weight > 70) System.out.println("Ты не сможешь поднять");
        else System.out.println("Ты сможешь поднять");
    }

    void mas(int w){ //перегрузка
        if (weight > w) System.out.println("Ты не сможешь поднять, ты слабый");
        else System.out.println("Ты сможешь поднять, ты сильный");
    }

    //todo внутренние классы
}
