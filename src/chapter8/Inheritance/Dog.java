package chapter8.Inheritance;

public final class Dog extends Animal implements Cloneable { //от финального класса нельзя наследоваться. Для клонирования надо реализовать Cloneable
    private String nick;

    Dog() {
        super();
        nick = "Unnamed";
    }

    Dog(int speed, int weight, String n) {
        super(speed, weight);
        nick = n;
    }

    void voice() {
        System.out.println("gav");
    }

    int dist(int h){
        System.out.println("Dog dist in " + h + " hours = " + h * speed);
        return h*speed;
    }

    @Override //перегрузка метода Object
    public Object clone() { //клонирование
        try {
            return super.clone(); //обратиться к методу класса Object
        } catch (CloneNotSupportedException e) { //если не реализует Cloneable
            System.out.println("Error Clone");
            return this;
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "nick='" + nick + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                '}';
    }
}
