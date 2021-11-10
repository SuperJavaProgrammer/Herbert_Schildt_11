package chapter12.EnumerationsAutoboxingAndAnnotations;

public enum City { //перечисление. Не может наследовать другой класс, не может быть супер-классом
    Moscow("Russia", 16), //значения перечисления через конструктор с параметрами
    Kiev("Ukraine", 5),
    New_York("USA", 12),
    London("UK", 10),
    Mars(); //использовать конструктор по умолачнию

    int population; //поля перечисления
    String country;

    City() { //конструктор по умолачнию
        this.country = "No Information";
        this.population = 0;
    }

    City(String country, int population) { //конструктор с параметрами
        this.country = country;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountry() {
        return country;
    }
}
