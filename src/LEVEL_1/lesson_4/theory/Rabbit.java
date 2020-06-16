package LEVEL_1.lesson_4.theory;

// Продолжение примера абстрактного класса
public class Rabbit extends Animal2 {
    @Override
    public void voice() {
        System.out.println("Кот мяукнул");
    }

    Animal2 a = new Rabbit();
}
