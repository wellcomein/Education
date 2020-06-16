package LEVEL_1.lesson_7.theory.game;

import javax.swing.*;

public class Game {
    // Ссылка на игровое поле. Приватное свойство игрового поля
    private GameBoard board;
    // Массив игроков
    private GamePlayer gamePlayers[] = new GamePlayer[2];
    // индекс текущего игрового хода
    private int playersTurn = 0;

    public Game() {
        // передаём в него текущий экземпляр нашей игры с помощью (this)
        this.board = new GameBoard(this);
    }

    // Инициация игры
    public void initGame() {
        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, 'O');
    }

    /**
     * Метод передачи хода
     */
    // мне кажется это потом нужно переписать и оптимизировать
    void passTurn() {
        if (playersTurn == 0) playersTurn = 1;
        else playersTurn = 0;
    }

    /**
     * Получение объекта текущего игрока
     * @return GamePlayer объект игры
     */
    // Возвращает массив игрока со значением 1 или 0
    GamePlayer getCurrentPlayer() {return gamePlayers[playersTurn];}

    /**
     * Метод показа всплывающего окна для пользователя
     * @param messageText - текст сообщения
     */
    // будет выводить сообещняи кто же выиграл или игра закончилась ничьей
    void showMessage(String messageText) {
        JOptionPane.showMessageDialog(board, messageText);
    }
}
