package LEVEL_1.lesson_4.theory;

// пример написания кода с геттерами и сеттерами.
public class Dog {
    // ...
    private String name;
    private int age;

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            System.out.println("Введен некорректный возраст");
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
