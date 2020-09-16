package LEVEL_1.lesson_4.homeTask;

public class Dog extends Animal {

    public Dog(double run, double swim, double jump) {
        super(run, swim, jump);
    }

    // 7. У каждого животного есть ограничения на действия (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);
    // 8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);
    // 9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.
    @Override
    public void run(double meters) {
        System.out.println("run: " + isCan(meters, this.run));
    }

    @Override
    public void swim(double meters) {
        System.out.println("swim: " + isCan(meters, this.swim));
    }

    @Override
    public void jump(double meters) {
        System.out.println("jump: " + isCan(meters, this.jump));
    }
}
