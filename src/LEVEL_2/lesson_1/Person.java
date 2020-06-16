package LEVEL_2.lesson_1;

class Person {
    private Object person;
    private String name;
    private int maxDistance;
    private int maxHeight;

    Person(Object person, int maxDistance, int maxHeight) {
        this.person = person;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;

    }


    @Override
    public String toString() {
        return "Person: " + person + ": maxDistance " + this.maxDistance + ", maxHeight " + maxHeight;
    }







}
