package LEVEL_1.lesson_4.theory;

// Пример интерфейса
interface CarTemplate {
    public String getId(); // Получить id автомобиля
    public String getName(); // Получить название
    public void move(); // Ехать
}

// Для реализации интерфейса используется оператор implements.
// Пример:
class Audi implements CarTemplate {
    public String getId() {
        return "1-ATHD98";
    }

    public String getName() {
        return "Audi";
    }

    public void move() {
        System.out.println(this.getName() + " is moving");
    }
}
