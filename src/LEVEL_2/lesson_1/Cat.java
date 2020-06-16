package LEVEL_2.lesson_1;

class Cat implements Abilities{
    final private String type = "cat";
    private String name;
    private int maxDistance;
    private int maxHeight;
    private boolean passed = true;

    Cat(String name, int maxDistance, int maxHeight) {
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
    public String run(Obstacle obstacle) {
        String result;
        if (obstacle.getDistance() > maxDistance) {
            result = "Ran unsuccessfully!";
            passed = false;
        }
        else result = "Successfully ran!";
        return run() + " on the " + obstacle.getName() + ". " + result;
    }
    @Override
    public String jump(Obstacle obstacle) {
        String result;
        if (obstacle.getHeight() > maxHeight) {
            result = "Jumped unsuccessfully!";
            passed = false;
        }
        else result = "Successfully jumped!";
        return jump() + " over the " + obstacle.getName() + ". " + result;
    }

    @Override
    public void move(Obstacle obstacle) {
        if (obstacle.isRunuble()) System.out.println(run(obstacle));
        else System.out.println(jump(obstacle));
    }

    @Override
    public boolean isPassed() {
        return passed;
    }
}
