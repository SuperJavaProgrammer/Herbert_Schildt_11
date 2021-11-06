package chapter8.Inheritance;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Murzik");
            cat.bigCat(); //Ты сможешь поднять Total in 5 hours = 250
            cat.dist(7); //Cat dist in 7 hours = 350
        Dog dog = new Dog(10, 20, "Drujok");
            dog.voice(); //gav
        Animal animal = new Cat("Musya"); //нельзя создать абстрактный класс, но можно конкретный, реализующий этот абстрактный
            animal.dist(9); //Cat dist in 9 hours = 90
        Animal animal2 = new Dog();
            animal2.dist(11); //Dog dist in 11 hours = 110

        Dog cloneDog = (Dog) dog.clone(); //клонирование
        System.out.println("dog=" + dog + ", cloneDog=" + cloneDog); //dog=Dog{nick='Drujok', speed=10, weight=20}, cloneDog=Dog{nick='Drujok', speed=10, weight=20}
        System.out.println(dog.hashCode()); //методы главного класса Object //1635985705
        System.out.println(dog.toString()); //Dog{nick='Drujok', speed=10, weight=20}
        System.out.println(dog.getClass()); //class chapter8.Inheritance.Dog
        System.out.println(animal.equals(animal2)); //false

    }
}
