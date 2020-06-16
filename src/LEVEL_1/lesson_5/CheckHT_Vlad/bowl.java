package LEVEL_1.lesson_5.CheckHT_Vlad;

public class bowl {
    private int volume = 50;                  // Объём миски
    private int HasNow = 0;                   // Еда в миске

    public bowl(int has){                    // Конструктор миски с параметром изначального количества еды в ней
        if (has<=volume)
        this.HasNow = has;
        else
            System.out.println("Error");
    }
    public void fill(){                     // Метод наполнения миски до верха
        SetFood(this.volume);
        System.out.println("Миска наполнена. В миске " + this.HasNow);
    }
    public boolean SetFood(int val){        // Метод наполнения миски. Если положить больше, чем объём миски, то false
        if (val<=this.volume) {
            this.HasNow = val;
            return true;
        }
        return false;
    }
    public int GetFood(){                   // Метод получения информации о количестве еды в миске
        return this.HasNow;
    }
    public void PrintFoodInBowl() {
        System.out.println("В миске осталось " + this.HasNow);
    }
}
