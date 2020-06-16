package LEVEL_1.lesson_4.theory;

// Еще одно применение super
class A {
    int i;
}

// Наследуемся от класса A
class B extends A {
    int i;             // Совпадающее имя скрывает переменную i в классе A

    B(int a, int b) {
        super.i = a;   // Обращаемся к переменной i из класса A
        i = b;         // Обращаемся к переменной i из класса B
    }

    void show() {
        System.out.println("i из суперкласса: " + super.i);
        System.out.println("i в подклассе: " + i);
    }
}



// Пример использования final в названиии класса
/*
public final class A {          // final в объявлении класса
}
public class B extends A { // Ошибка: у класса A не может быть подклассов
}
*/