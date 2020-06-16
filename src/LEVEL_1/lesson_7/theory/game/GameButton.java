package LEVEL_1.lesson_7.theory.game;

import javax.swing.*;

public class GameButton extends JButton {
    private GameBoard board;        // ссылка на игровое поле

    // при создании кнопки входными параметрами будут:
    // указываться её индекс, который бует расчитываться при её создании
    // и указываем ссылку на игровое поле
    public GameButton(int gameButtonIndex, GameBoard currentGameBoard) {
        // индекс кнопки
        board = currentGameBoard;

        // расчитывается номер ряда и номер ячейки
        int rowNum = gameButtonIndex / GameBoard.dimension;
        int cellNum = gameButtonIndex % GameBoard.dimension;

        // задаём размер кнопки
        setSize(GameBoard.cellSize -5, GameBoard.cellSize -5);
        // навешиваем на кнопку слушателя, в который передаём её индексы и ссылку на текущую кнопку
        addActionListener(new GameActionListener(rowNum, cellNum, this));
    }

    // Возвращает ссылку на игровую доску для нашей кнопки
    public GameBoard getBoard() {return board;}
}
