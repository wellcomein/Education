package LEVEL_1.lesson_7.theory.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static final int dimension = 3;           // размерность клеток игры
    static final int cellSize = 150;          // размер одной клетки
    private char[][] gameField;         // матрица игры
    private GameButton[] gameButtons;   // массив кнопок
    private boolean smartComputer = false;
    private boolean brilliantComputer = false;

    private Game game;                  // ссылка на игру

    private static final char nullSymbol = '\u0000';  // null символ

    public GameBoard(Game currentGame) {
        this.game = currentGame;
        initField();
    }
    // основной метод который будет отвечать за отрисовку нашего поля
    private void initField() {
        // задаём основные настройки окна игры
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);        // задаём размер поля
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // создаём поле
        setLayout(new BorderLayout());

        // панель управления игрой
        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // метод отвечает за очистку нашего поля
                emptyField();
            }
        });

        // кнопка выбора гениальности компьютера
        JButton smartComputerButton = new JButton("Умный компьютер от GeekBrains");
        smartComputerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smartComputer = true;
            }
        });

        // кнопка выбора супер-гениального компьютера
        JButton MyComputerButton = new JButton("Гениальный компьютер от меня");
        smartComputerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brilliantComputer = true;
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.add(smartComputerButton);
        controlPanel.add(MyComputerButton);
        controlPanel.setSize(cellSize * dimension, 150);

        // создаём панель самой игры
        JPanel gameFieldPanel = new JPanel();
        // менеджер размещения убдет GridLayout, так как размещение в виде таблицы
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        // инициализируем игровое поле. То есть заполняем его кнопочками
        for (int i = 0; i < (dimension * dimension); i++) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }
        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Метод очистки поля и матрицы игры
     */
    void emptyField() {
        for (int i = 0; i < (dimension * dimension); i++) {
            gameButtons[i].setText("");
            int x = i / dimension;                              // убрал ссылка на класс
            int y = i % dimension;                              // убрал ссылку на класс

            gameField[x][y] = nullSymbol;
        }
    }
    Game getGame() {return game;}

    /**
     * Метод проверки доступности клетки для хода
     * @param x - по горизонтали
     * @param y - по вертикали
     * @return boolean
     */
    boolean isTurnable(int x, int y) {
        boolean result = false;

        if (gameField[y][x] == nullSymbol) result = true;
        return result;
    }

    /**
     * Обновление матрицы игры после хода
     * @param x - по горизонтали
     * @param y - по вертикали
     */
    void updateGameField(int x, int y) {
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    /**
     * Проверка победы по столбцам и линиям
     * @return флаг победы
     */
    boolean checkWin() {
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();
        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) result = true;
        return result;
    }

    /**
     * Метод проверки заполненности поля
     * @return
     */
    boolean isFull() {
        boolean result = true;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (gameField[i][j] == nullSymbol) result = false;
            }
        }
        return result;
    }


    /**
     * Проверка победы по линиям и столбцам
     * @param playerSymbol
     * @return
     */
    private boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;
        result = false;
        for (int col = 0; col < dimension; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < dimension; row++) {
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }
            // Это условие после каждой проверки колонки и столбца
            // позволяет остановить дальнейшее выполненние, без проверки
            // всех остальных столбцов и строк
            if (cols || rows) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Провера победы на диагоналях
     * @param playerSymbol - символ игрока
     * @return - если true то выигрыш по диагонали
     */
    private boolean checkWinDiagonals(char playerSymbol) {
        boolean leftRight, rightLeft, result;
        leftRight = true;
        rightLeft = true;
        result = false;

        for (int i = 0; i < dimension; i++) {
            leftRight &= (gameField[i][i] == playerSymbol);
            rightLeft &= (gameField[dimension -i-1][i] == playerSymbol);
        }
        if(leftRight || rightLeft) result = true;
        return result;
    }

    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }
    /**
     * Метод проверки занято ли поле игроком
     * @param x - по горизонтали
     * @param y - по вертикали
     * @return boolean
     */
    boolean isPlayerFild(int x, int y) {
        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();
        boolean result = false;

        if (gameField[y][x] == playerSymbol) result = true;
        return result;
    }

    public boolean getSmartComputer() {
        return smartComputer;
    }
    public boolean getBrilliantComputer() {
        return brilliantComputer;
    }

    public char getGameField(int x, int y) {
        return gameField[x][y];
    }
}
