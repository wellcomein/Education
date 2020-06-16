package LEVEL_2.lesson_1;

class Human implements Abilities{
    final private String type = "human";
    private String name;
    private int maxDistance;
    private int maxHeight;
    private boolean passed = true;

    Human(String name, int maxDistance, int maxHeight) {
        this.name = name;
        if (maxDistance < 0) throw new IllegalArgumentException("Incorrect input value");
        if (maxHeight < 0) throw new IllegalArgumentException("Incorrect input value");
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public String run() {
        return type + " " + name + " is running";
    }
    @Override
    public String jump() {
        return type + " " + name + " is jumping";
    }
    @Override
    public String run(Discipline discipline) {
        String result;
        if (discipline.getDistance() > maxDistance) {
            result = "Ran unsuccessfully!";
            passed = false;
        }
        else result = "Successfully ran!";
        return run() + " on the " + discipline.getName() + ". " + result;
    }
    @Override
    public String jump(Discipline discipline) {
        String result;
        if (discipline.getHeight() > maxHeight) {
            result = "Jumped unsuccessfully!";
            passed = false;
        }
        else result = "Successfully jumped!";
        return jump() + " over the " + discipline.getName() + ". " + result;
    }

    @Override
    public void move(Discipline discipline) {
        if (discipline.isRunuble()) System.out.println(run(discipline));
        else System.out.println(jump(discipline));
    }

    @Override
    public boolean isPassed() {
        return passed;
    }
}
