package LEVEL_1.lesson_4.theory;

public class Cat extends Beast {
    protected String color;

    public Cat(String name, int pawsNumber, String color) {
        this.name = name;
        this.pawsNumber = pawsNumber;
        this.color = color;
    }
    public void catInfo() {
        System.out.println("Cat: " + name + " Color " + color);
    }

}



