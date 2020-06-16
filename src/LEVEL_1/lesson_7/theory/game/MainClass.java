package LEVEL_1.lesson_7.theory.game;

public class MainClass {
    public static void main(String[] args) {
        Game gameInstance = new Game();     // создаётся экземпляр игры
        gameInstance.initGame();            // создание двух игроков для нового экземпляра игры в классе Game
        System.out.println();
    }
}
/*
Порядок игры:
1. создание экземпляра игры gameInstance класса Game
1.01. в парамеьре board класса GameBoard создаётся новая игровая доска
2. для экземпляра игры gameInstance создание двух игроков в классе Game






emptyField() - убрал ссылку на класс для параметра dimension
класс GameActionListener - доступ default
класс GamePlayer - доступ default
параметр nullSymbol - доступ private
параметр dimension - final
параметр cellSize - final
параметр nullSymbol - final
 */