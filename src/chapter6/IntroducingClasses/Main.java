package chapter6.IntroducingClasses;

public class Main {

    public static void main(String[] args) {
        Animal tiger = new Animal(); //создание объекта класса
            tiger.speed = 70; //установка параметров
            tiger.weight = 60;
        int tigerDist = tiger.dist(2); //вызов метода
        tiger.mas(); //Ты сможешь поднять
        System.out.println("Tiger=" + tigerDist); //Tiger=140

        var panda = new Animal(20,90); //создание другого объекта
        panda.mas(); //Ты не сможешь поднять
        System.out.println("Panda=" + panda.dist(3)); //Total in 3 hours = 60

        var panda2 = panda; //не создание нового объекта, а присваивание ссылки на другой объект
            panda2.speed = 100;
            panda2.weight = 10;
        System.out.println("Update Panda=" + panda.dist(3)); //Update Panda=300
        System.out.println("Update Panda2=" + panda2.dist(3)); //Update Panda2=300
        panda.mas(); //Ты сможешь поднять
        panda2.mas(); //Ты сможешь поднять

        var mouse = new Animal(15, 15);
        System.out.println("Mouse=" + mouse.dist(10)); //Mouse=150
        mouse.mas(); //Ты сможешь поднять
    }
}
