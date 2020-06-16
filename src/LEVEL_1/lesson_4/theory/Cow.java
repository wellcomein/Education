package LEVEL_1.lesson_4.theory;

// Создание, объявление объектов, присваивание им переменных.
public class Cow {

    // Создание переменных класска Cow
    String name;
    String color;
    int age;

    // присваивание всем объектам класса Cow одинаковых значений переменных.
    public Cow() {
        System.out.println("Это конструктор класса Cow") ;
        name = "Milka";
        color = "White";
        age = 2;
    }

    //  добавить в конструктор набор параметров
    public Cow(String _name, String _color, int _age) {
        name = _name;
        color = _color;
        age = _age;
    }

    // Чтобы метод ссылался на вызвавший его объект, в Java определено ключевое слово this
    public Cow(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getCowName(){
        return this.name;
    }

    // Конкретный пример
    public static void main(String[] args) {

        // Создание объектов класса Cow
        Cow cow1 = new Cow();
        Cow cow2 = new Cow();

        // Присваивание объектам Cow1 и Cow2 различных значений в поля
        cow1.name = "Barsik";
        cow1.color = "White";
        cow1.age = 4;
        cow2.name = "Murzik";
        cow2.color = "Black";
        cow2.age = 6;
        System.out.println("Cow1 name: " + cow1.name + " color: " + cow1.color + " age: " + cow1.age);
        System.out.println("Cow2 name: " + cow2.name + " color: " + cow2.color + " age: " + cow2.age);


        // Теперь cow4 ссылается на тот же объект, что и cow3
        Cow cow3 = new Cow();
        Cow cat4 = cow3;
    }

    // Пример добавления двух объектов класса Cow
    Cow cow1 = new Cow("Barsik", "Brown", 4);
    Cow cow2 = new Cow("Murzik", "White", 5);
}
