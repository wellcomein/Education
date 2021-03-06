package LEVEL_1.lesson_5.homeTask;

import LEVEL_1.lesson_4.homeTask.Cat;

// 1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи.
// У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;

class SuperCat extends Cat{
    protected String name;
    protected int appetite;
    protected boolean satiety;

    protected SuperCat(String name, double run, double swim, double jump, int appetite) {
        super(run, swim, jump);
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    protected void SuperCatInfo() {
        System.out.println("Name: " + name + ", run: " + run + ", swim: " + swim + ", jump: " + jump + ", appetite: " + appetite);
    }

    protected int Eating(int FOOD) {
        if(FOOD >= appetite && !satiety) {
            FOOD = FOOD - appetite;
            this.satiety = true;
        }
        return FOOD;
    }
    protected void isHungry() {
        if (!this.satiety) System.out.println(this.name + " is hungry.");
        else System.out.println(this.name + " is full.");
    }
}
