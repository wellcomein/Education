package LEVEL_1.lesson_5.CheckHT_Vlad;

public class Dog extends animal {

    public Dog(String _name) {
      this.name = _name;
      this.MaxRun = rand(500);
      this.MaxSwim = 10;
      this.MaxHeight = rand(200);
    }

}
