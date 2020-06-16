package LEVEL_1.lesson_7.theory.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class GameActionListener implements ActionListener {
    private int cell;
    private int row;
    private GameButton button;      // ссылка на нашу кнопку
    private GameBoard board;        // ссылка на доску

    // в качестве входного параметра созда1тся ссылка на кнопку к которой привязываем ActionListener
    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);

            if (board.isFull()) {
                board.getGame().showMessage("Ничья");
                board.emptyField();
            }
            else {
                if (board.getSmartComputer()) SmartComputer(board);
                else if (board.getBrilliantComputer()) MyComputer();
                else updateByAiData(board);
            }

        }
        else board.getGame().showMessage("Некорректный ход");

    }

    /**
     * Ход человека
     * @param board GameBoard - ссылка на игровое поле
     */
    private void updateByPlayersData(GameBoard board) {
        // обновить матрицу игры
         board.updateGameField(row,cell);

         // обновить содержимое кнопки. Используется класс-обёртка, превращающий значение char в String
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли");
            board.emptyField();
        }
        else {
            board.getGame().passTurn();     // иначе передали ход

        }
    }

    /**
     * Режим глупого компьютера
     * @param board - ссылка на игровое поле
     */
    private void updateByAiData(GameBoard board) {
        // генерация координат хода компьютера
        int x, y;
        Random rnd = new Random();

        do {
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
        }
        while(!board.isTurnable(x,y));

        // обновить матрицу игры
        board.updateGameField(x, y);

        // обновить содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        // проверить победу
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл");
            board.emptyField();
        }
        else {
            // передать ход
            board.getGame().passTurn();
        }
    }

    /**
     * Алгоритм умного компьютера
     */
    private void SmartComputer(GameBoard board) {
        // генерация координат хода компьютера
        int x, y;

        // переменные для подсчёта очков
        int maxScoreFieldX = -1;
        int maxScoreFieldY = -1;
        int maxScore = 0;

        // /*
        for (int i = 0; i < GameBoard.dimension; i++) {
            for (int j = 0; j < GameBoard.dimension; j++) {
                int fieldScore = 0;
                if (board.isTurnable(i,j)) {
                    //　проверяем направления
                    // left up
                    if(i - 1 >= 0 && j - 1 >= 0 && board.isPlayerFild(i-1, j-1)) fieldScore++;
                    // up
                    if (i - 1 >= 0 && board.isPlayerFild(i-1, j)) fieldScore++;
                    // right up
                    if (i - 1 >=0 && j + 1 < GameBoard.dimension && board.isPlayerFild(i-1, j+1)) fieldScore++;
                    // right
                    if (j + 1 < GameBoard.dimension && board.isPlayerFild(i, j+1)) fieldScore++;
                    // right down
                    if (i + 1 < GameBoard.dimension && j + 1 < GameBoard.dimension && board.isPlayerFild(i+1, j+1)) fieldScore++;
                    // down
                    if (i + 1 < GameBoard.dimension && board.isPlayerFild(i+1, j)) fieldScore++;
                    // left down
                    if (i + 1 < GameBoard.dimension && j - 1 >= 0 && board.isPlayerFild(i+1, j-1)) fieldScore++;
                    // left
                    if (j -1 >=0 && board.isPlayerFild(i, j-1)) fieldScore++;
                }
                if (fieldScore > maxScore) {
                    maxScore = fieldScore;
                    maxScoreFieldX = i;
                    maxScoreFieldY = j;
                }
            }
        }
        // если в цикле найдена наилучшая клетка
        if (maxScoreFieldX != -1) {
            x = maxScoreFieldX;
            y = maxScoreFieldY;
        }
        // если ничего не нашли, делаем глупый ход
        else {
            Random rnd = new Random();

            do {
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            }
            while(!board.isTurnable(x,y));
        }

        // обновить матрицу игры
        board.updateGameField(x, y);

        // обновить содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        // проверить победу
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл");
            board.emptyField();
        }
        else {
            // передать ход
            board.getGame().passTurn();
        }
    }


    //-------------------------------------------------------------------------
    // Мой умный компьютер
    private int[][] POINTS = new int[GameBoard.dimension][GameBoard.dimension];
    private int SIZE = GameBoard.dimension;
    private static Random random = new Random();
    private void Fill_Points_Board(GameBoard board) {
        char enemySymbol;
        char friendSymbol;


        if (board.getGame().getCurrentPlayer().getPlayerSign() == 'O') {
            friendSymbol = 'O';
            enemySymbol = 'X';
        }
        else {
            friendSymbol = 'X';
            enemySymbol = 'O';
        }

        // присваивается очко, если пустая ячейка
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board.isTurnable(i,j)) POINTS[i][j] = 1;
                if (!board.isTurnable(i,j)) POINTS[i][j] = 0;
            }
        }

        // присваивается плюс очко, если рядом два своих знака
        Point_Equality(friendSymbol, 1);
        Point_Equality(enemySymbol,2);  // присваивается плюс два очка, если рядом два О

        // присваивается 4 очка угловым ячейкам, если они пустые. Если пустой центр, то присваивается 5 очков
        if (board.isTurnable(0,0) && board.isTurnable(0,SIZE-1) && board.isTurnable(SIZE-1,0) && board.isTurnable(SIZE-1,SIZE-1)) {
            POINTS[0][0] = 4;
            POINTS[0][SIZE-1] = 4;
            POINTS[SIZE-1][0] = 4;
            POINTS[SIZE-1][SIZE-1] = 4;
        }
        if (board.isTurnable((SIZE-1)/2,(SIZE-1)/2)) POINTS[(SIZE-1)/2][(SIZE-1)/2] = 5;
    }
    // вспомогательные методы
    private void Point_Equality(char player, int rating) {
        Check_Strings(player, rating);         // проверка строк
        Check_Columns(player, rating);        // проверка столбцов
        Check_Diagonal_Left(player, rating);        // проверка диагонали слева направо
        Check_Diagonal_Right(player, rating);        // проверка диагонали справа налево
    }

    // вспомогательные методы для процедуры Point_Equality
    private void Check_Strings(char player, int rating) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board.getGameField(i, j) == player) counter++;
            }
            if (counter == SIZE - 1) {
                for (int j = 0; j < SIZE; j++) {
                    if (POINTS[i][j] == 1) POINTS[i][j] += rating;
                }
            }
        }
    }
    private void Check_Columns(char player, int rating) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board.getGameField(j, i) == player) counter++;
            }
            if (counter == SIZE - 1) {
                for (int j = 0; j < SIZE; j++) {
                    if (POINTS[j][i] == 1) POINTS[j][i] += rating;
                }
            }
        }
    }
    private void Check_Diagonal_Left(char player, int rating) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (board.getGameField(i, i) == player) counter++;
        }
        if (counter == SIZE - 1) {
            for (int i = 0; i < SIZE; i++) {
                if (POINTS[i][i] == 1) POINTS[i][i] += rating;
            }
        }
    }
    private void Check_Diagonal_Right(char player, int rating) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (board.getGameField(i, SIZE-1-i) == player) counter++;
        }
        if (counter == SIZE - 1) {
            for (int i = 0; i < SIZE; i++) {
                if (POINTS[i][SIZE-1-i] == 1) POINTS[i][SIZE-1-i] += rating;
            }
        }
    }

    private void MyComputer() {
        // Находится максимальное значение в массиве POINTS
        int max_point = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (POINTS[i][j] > max_point) max_point = POINTS[i][j];
            }
        }
        while (true) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);

            if (POINTS[x][y] == max_point) {
                // обновить матрицу игры
                board.updateGameField(x, y);

                // обновить содержимое кнопки
                int cellIndex = GameBoard.dimension * x + y;
                board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
                break;
            }
        }

        // проверить победу
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл");
            board.emptyField();
        }
        else {
            // передать ход
            board.getGame().passTurn();
        }
    }

}
