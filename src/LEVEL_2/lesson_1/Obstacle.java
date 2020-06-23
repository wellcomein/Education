package LEVEL_2.lesson_1;

/**
 * Родитель классов Беговая дорожка и Стена.
 * Служит для тех же целей, что и класс Abilities, но с возможностью промисать тело в классах.
 * Все методы класса служат для инкапсуляции параметров.
 */
abstract class Obstacle {
    private String name;
    private boolean runuble;
    private int distance;
    private int height;

    void setName(String name) {
        this.name = name;
    }
    void setRunuble(boolean runuble) {
        this.runuble = runuble;
    }
    void setDistance(int distance) {
        if (distance < 0) throw new IllegalArgumentException("Incorrect input value");
        this.distance = distance;
    }
    void setHeight(int height) {
        if (height < 0) throw new IllegalArgumentException("Incorrect input value");
        this.height = height;
    }

    String getName() {
        return name;
    }
    int getDistance() {
        return distance;
    }
    int getHeight() {
        return height;
    }

    boolean isRunuble() {
        return runuble;
    }
}
