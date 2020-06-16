package LEVEL_2.lesson_1;

public class Main {
    /**
     * Цикл для запуска и проверки и вывода в консоль.
     */
    private static void exam(Abilities[] person, Discipline[] discipline) {
        for (int i = 0; i < person.length; i++) {
            if (!person[i].isPassed()) break;
            for (int j = 0; j < discipline.length; j++) {
                if (!person[i].isPassed()) break;
                person[i].move(discipline[j]);
            }
        }
    }
    public static void main(String[] args) {

        Abilities[] person = {
                new Human("Reichel",200,1),
                new Human("Klark", 500, 2),
                new Cat("Bars",20,4),
                new Cat("Murzik", 10,3),
                new Robot("Bender", 1000,1000),
                new Robot("Robocop", 400, 0)
        };
        Discipline[] discipline = {
                new Treadmill("treadmill 1", 100),
                new Treadmill("treadmill 2", 400),
                new Wall("wall 1", 1),
                new Wall("wall 2", 2)
        };

        exam(person, discipline);
    }
}
