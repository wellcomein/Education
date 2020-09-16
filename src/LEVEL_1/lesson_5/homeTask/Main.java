package LEVEL_1.lesson_5.homeTask;
/*
Задачи на взаимодействие классов:
+ 1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи. У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;

+ 2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней, а также методами наполнения и получения информации о количестве еды;

+ 3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски, уменьшая объём еды в ней;

+ 4. Предусмотрите проверку, при которой в миске не может получиться отрицательного количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);

+ 5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть (хватило еды), сытость = true;

+ Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы);

+ 6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль;

+ 7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
 */

public class Main {

    public static void main(String[] args) {

        // give birth to a cats
        SuperCat[] superCat = new SuperCat[3];
        superCat[0] = new SuperCat("Quasimodo",20, 20, 20, 20);
        superCat[1] = new SuperCat("Megamind", 30,30,30,10);
        superCat[2] = new SuperCat("Alien", 40, 40,40,40);

        // how looks our cats
        for (SuperCat cat : superCat) {
            cat.SuperCatInfo();
        }

        // buying the bowl for cats
        Bowl bowl1 = new Bowl();

        boolean is_cats_full;
        do {
            // put a food in the bowl
            bowl1.putFood_in_Bowl();

            // cats eating from the bowl
            for (int i = 0; i < superCat.length; i++) {
                bowl1.food = superCat[i].Eating(bowl1.food);
            }
            System.out.println("Cats have finished eating");

            // see in the bowl to find out how many food in it
            bowl1.Info_about_Bowl();

            // check cats satiety
            is_cats_full = true; // need for do-while
            for (int i = 0; i < superCat.length; i++) {
                superCat[i].isHungry();
                if (!superCat[i].satiety) is_cats_full = false;
            }
        }
        while (!is_cats_full);
    }
}
