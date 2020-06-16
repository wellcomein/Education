package LEVEL_1.lesson_4.CheckHT_Vlad;

import java.util.Random;

public class animal {
    protected String name;
    protected int MaxRun;
    protected int MaxSwim;
    protected int MaxHeight;

    public int rand(int bounds) {
        Random r = new Random();
        return r.nextInt(bounds);
    }
    public void limits(){
        System.out.println("Макс бег: " + this.MaxRun +
                " Макс swim: " + this.MaxSwim + " Макс jump: " + this.MaxHeight);
    }
    public boolean run(int _run){
        if (_run<this.MaxRun) return true;
        else return false;
    }
    public boolean jump(int _jump){
        if (_jump<this.MaxHeight) return true;
        else return false;
    }
    public boolean swim(int _sw){
        if (_sw<this.MaxSwim) return true;
        else return false;
    }

}


