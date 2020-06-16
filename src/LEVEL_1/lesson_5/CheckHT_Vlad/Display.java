package LEVEL_1.lesson_5.CheckHT_Vlad;

public class Display {
    public static void main(String[] args) {
     bowl bowl1 = new bowl(25);
     Cat cat1 = new Cat("Барсик");
     Cat cat2 = new Cat("Вася");
     Cat cat3 = new Cat("Кот3");



     bowl1.PrintFoodInBowl();
     cat1.eat(bowl1);
     bowl1.PrintFoodInBowl();


     if(!cat2.eat(bowl1)) {bowl1.fill(); cat2.eat(bowl1);}
     bowl1.PrintFoodInBowl();
     //if(!cat3.eat(bowl1)) {bowl1.fill(); cat2.eat(bowl1);}
     //System.out.println(bowl1.GetFood());
     //if(!cat1.eat(bowl1)) {bowl1.fill(); cat2.eat(bowl1);}
     //System.out.println(bowl1.GetFood());

    }
}

/*
5. Создать классы Собака и Кот с наследованием от класса Животное;
6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия
 (для бега и плавания), или высоту (для прыжков);
7. У каждого животного есть ограничения на действия (бег: кот – 200 м., собака – 500 м.;
 прыжок: кот – 2 м., собака – 0.5 м.;
  плавание: кот не умеет плавать, собака – 10 м.);
8. При попытке животного выполнить одно из этих действий,
 оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);
9. * Добавить животным разброс в ограничениях.
То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м

*/