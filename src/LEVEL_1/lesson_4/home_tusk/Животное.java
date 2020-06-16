package LEVEL_1.lesson_4.home_tusk;

// ЗАПУСКАЕТСЯ ПРОГРАММА ИЗ MainClass9
//5. Создать классы Собака и Кот с наследованием от класса Животное;
public abstract class Животное {

    /*
    6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    В качестве параметра каждому методу передается величина,
    означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);
     */
    public double run;
    public double swim;
    public double jump;

    public Животное(double run, double swim, double jump) {
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public abstract void run(double meters);
    public abstract void swim(double meters);
    public abstract void jump(double meters);

    public boolean isCan(double meters, double limitat) {
        if ((meters <= limitat) && (meters >= 0)) return true;
        return false;
    }
}