package LEVEL_1.lesson_4.CheckHT_Vlad;

class Cat extends animal {

    Cat(String _name) {
        this.name = _name;
        this.MaxRun = rand(200);
        this.MaxSwim = 0;
        this.MaxHeight = rand(2);
    }

}
