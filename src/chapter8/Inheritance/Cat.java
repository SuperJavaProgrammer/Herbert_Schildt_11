package chapter8.Inheritance;

public class Cat extends Animal { //класс расширяет асбтрактный, реализует его абстрактные методы, может перегружать конкретные методы
    private String name; //новое поле

    Cat(String n) {
        super(); //обратиться к суперклассу
        name = n;
    }

    Cat(int speed, int weight, String n) {
        super(speed, weight); //обратиться к суперклассу, передать для заполнения там свои параметры
        name = n;
    }

    void voice() {
        System.out.println("mew"); //реализация абстраткного метода
    }

    final void notChange() { //финальные методы нельзя переопределить
        System.out.println("Can not change");
    }

    void bigCat() {
        super.speed = 50; //обратиться к переменной суперкласса
        super.weight = 30;
        super.mas(); //обратиться к методу суперкласса
        super.dist(5);
    }

    int dist(int h){ //перегрузка метода родительского класса
        System.out.println("Cat dist in " + h + " hours = " + h * speed);
        return h * speed;
    }

    void getSpeed() {
        System.out.println("Speed=" + speed);
    }
}
