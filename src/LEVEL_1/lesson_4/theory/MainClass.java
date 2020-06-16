package LEVEL_1.lesson_4.theory;

public class MainClass {
    public static void main(String[] args) {
        Animal animal = new Animal("Animal");
        Cat cat = new Cat("Barsik", 4, "White");
        animal.animalInfo();
        cat.animalInfo();
        cat.catInfo();
    }
}
/*
Результат:
        Animal: animal
        Animal: Barsik
        Cat: Barsik White
*/
