package LEVEL_1.lesson_5.CheckHT_Vlad;

public class Cat extends animal {

    int CanEat = 0;
    boolean hungry = true;

    public Cat(String _name) {
        this.name = _name;
        this.MaxRun = rand(200);
        this.MaxSwim = 0;
        this.MaxHeight = rand(2);
        this.CanEat = rand(20);
    }
    public boolean eat(bowl bow){                       // Метод взаиможействия с миской. Кот ест из миски
        int hasfood = bow.GetFood();
        if(hasfood>=this.CanEat) {                      // Если еды в миске больше, чем может съесть кот
            bow.SetFood(hasfood - this.CanEat);     // Кот ест. Присваиваем количеству еду в миске новое значение.
            this.hungry = false;
            System.out.println("Кот " + this.name + " успешно поел. Съел " + this.CanEat);
            return true;
        }
        System.out.println("Коту " + this.name + " не хватило еды");
        return false;
    }

}
