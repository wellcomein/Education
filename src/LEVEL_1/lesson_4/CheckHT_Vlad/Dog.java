package LEVEL_1.lesson_4.CheckHT_Vlad;

class Dog extends animal {

    Dog(String _name) {
      this.name = _name;
      this.MaxRun = rand(500);
      this.MaxSwim = 10;
      this.MaxHeight = rand(200);
    }

}
