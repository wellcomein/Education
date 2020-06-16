package LEVEL_1.lesson_4.home_tusk;

public class MainClass {
    public static void main(String[] args) {
        Dog dog1 = new Dog(400, 5, 1); // Вводятся ограничения
        Dog dog2 = new Dog(600, 20, 0.5);
        Cat cat1 = new Cat(200, 0, 2); // Базовые значения из задания 7

        // Если указывать значение в скобках, то срабатывает зазание 8, если без скобок, то задание 9.
        dog1.run(600);
        dog2.run(120);
        cat1.jump(2);
        cat1.swim(3);
    }
}
