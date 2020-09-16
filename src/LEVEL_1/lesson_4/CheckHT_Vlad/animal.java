package LEVEL_1.lesson_4.CheckHT_Vlad;

import java.util.Random;

class animal {
    protected String name;
    protected int MaxRun;
    protected int MaxSwim;
    protected int MaxHeight;

    protected int rand(int bounds) {
        Random r = new Random();
        return r.nextInt(bounds);
    }
    void limits(){
        System.out.println("Макс бег: " + this.MaxRun +
                " Макс swim: " + this.MaxSwim + " Макс jump: " + this.MaxHeight);
    }
    boolean run(int _run){
        return _run < this.MaxRun;
    }
    boolean jump(int _jump){
        return _jump < this.MaxHeight;
    }
    boolean swim(int _sw){
        return _sw < this.MaxSwim;
    }

}


