package chapter8.Inheritance;

public abstract class Animal { //абстрактный класс, нельзя создать его объект
    int speed = 5;
    int weight = 5;

    Animal() {
        speed = 10;
        weight = 10;
    }

    abstract void voice(); //абстрактный метод, надо реализовать в конкретных классах

    Animal(int speed, int weight) {
        this.speed = speed;
        this.weight = weight;
    }

    int dist(int h){
        System.out.println("Total in " + h + " hours = " + h * speed);
        return h*speed;
    }

    void mas(){
        if (weight > 70) System.out.println("Ты не сможешь поднять");
        else System.out.println("Ты сможешь поднять");
    }

}
