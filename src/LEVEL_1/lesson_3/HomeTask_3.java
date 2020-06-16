package LEVEL_1.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class HomeTask_3 {
    // ИГРА КРЕСТИКИ-НОЛИКИ
    // Массив с баллами можно вывести в консоль с помощью метода Show_Points_Board()

    private static final int SIZE = 3;
    private static final char X = 'X';
    private static final char O = 'O';
    private static final char EMPTY = ' ';

    private static char[][] BOARD = new char [SIZE][SIZE];
    private static int[][] POINTS = new int[SIZE][SIZE];

    private static Random random = new Random();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hi! Please play tic-tac-toe.");
        boolean computer = isComputer();
        boolean stupid = isStupid();
        Fill_My_Board();

        for (int i = 0; i < SIZE * SIZE; i++) {
            Show_My_Board();
            if(is_Board_Full() == true) break;
            Human_Go();
            if(is_Win() == true) break;
            if(is_Board_Full() == true) break;
            if(computer == false) {
                if (stupid == true) Stupid_Computer_Go();
                else {
                    Fill_Points_Board();
                    Smart_Computer_Go();
                }
            }
            else Human_Second_Go();
            if(is_Win() == true) break;
        }
    }
    private static void Fill_My_Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                BOARD[i][j] = EMPTY;
            }

        }
    }
    private static void Show_My_Board() {
        System.out.print(" ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(BOARD[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void Show_Points_Board() {
        System.out.println("  " + 0 + " " + 1 + " " + 2);
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(POINTS[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean is_Board_Full() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(BOARD[i][j] == EMPTY) return false;
            }
        }
        Show_My_Board();
        System.out.println("Game over. You have a draw.");
        return true;
    }
    private static void Human_Go() {
        System.out.print("Please enter y and x (values between 1 and " + SIZE + "): ");
        while(true) {
            int i = userInput.nextInt();
            int j = userInput.nextInt();
            if((i >= 1) && (i <=SIZE) && (j >= 1) && (j <=SIZE) && (BOARD[i-1][j-1] == EMPTY)) {
                BOARD[i-1][j-1] = X;
                break;
            }
            System.out.print("Input incorrect. Please try again: ");
        }
    }
    private static void Human_Second_Go() {
        System.out.print("Please enter y and x (values between 1 and " + SIZE + "): ");
        while(true) {
            int i = userInput.nextInt();
            int j = userInput.nextInt();
            if((i >= 1) && (i <=SIZE) && (j >= 1) && (j <=SIZE) && (BOARD[i-1][j-1] == EMPTY)) {
                BOARD[i-1][j-1] = O;
                break;
            }
            System.out.print("Input incorrect. Please try again: ");
        }
    }
    private static boolean is_Win() {
        int Human_Win_Cross1 = 0;
        int Human_Win_Cross2 = 0;
        int Computer_Win_Cross1 = 0;
        int Computer_Win_Cross2 = 0;
        for (int i = 0; i < SIZE; i++) {
            int Human_Win_String = 0;
            int Human_Win_Column = 0;
            int Computer_Win_String = 0;
            int Computer_Win_Column = 0;

            if(BOARD[i][i] == X) Human_Win_Cross1++;
            if(BOARD[i][SIZE-1-i] == X) Human_Win_Cross2++;
            if(BOARD[i][i] == O) Computer_Win_Cross1++;
            if(BOARD[i][SIZE-1-i] == O) Computer_Win_Cross2++;

            for (int j = 0; j < SIZE; j++) {
                if(BOARD[i][j] == X) Human_Win_String++;
                if(BOARD[j][i] == X) Human_Win_Column++;
                if(BOARD[i][j] == O) Computer_Win_String++;
                if(BOARD[j][i] == O) Computer_Win_Column++;
            }
            if(Human_Win_String == SIZE || Human_Win_Column == SIZE || Human_Win_Cross1 == SIZE || Human_Win_Cross2 == SIZE) {
                Show_My_Board();
                System.out.println("You win!");
                return true;
            }
            if(Computer_Win_String == SIZE || Computer_Win_Column == SIZE || Computer_Win_Cross1 == SIZE || Computer_Win_Cross2 == SIZE) {
                Show_My_Board();
                System.out.println("Game over! Try again.");
                return true;
            }
        }
        return false;
    }
    private static void Smart_Computer_Go() {
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
                BOARD[x][y] = O;
                break;
            }
        }
    }
    private static void Stupid_Computer_Go() {
        while (true) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            if (BOARD[x][y] == EMPTY) {
                BOARD[x][y] = O;
                break;
            }
        }
    }
    private static boolean isStupid() {
        System.out.print("Would you like to play with smart computer? If yes - enter 1. ");
        String answer = userInput.nextLine();
        if (answer.equals("1")) return false;
        return true;
    }
    private static boolean isComputer() {
        System.out.print("Would you like to play with computer or human? If computer - enter 1. ");
        String answer = userInput.nextLine();
        if (answer.equals("1")) return false;
        return true;
    }
    private static void Fill_Points_Board() {
        Point_Empty();  // присваивается очко, если пустая ячейка
        Point_Equality(X, 1); // присваивается плюс очко, если рядом два Х
        Point_Equality(O,2);  // присваивается плюс два очка, если рядом два О
        Point_Corners_Center();   // присваивается 4 очка угловым ячейкам, если они пустые. Если пустой центр, то присваивается 5 очков
    }

    // вспомогательные методы
    private static void Point_Empty() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (BOARD[i][j] == EMPTY) POINTS[i][j] = 1;
                if (BOARD[i][j] != EMPTY) POINTS[i][j] = 0;
            }
        }
    }
    private static void Point_Equality(char player, int rating) {
        Check_Strings(player, rating);         // проверка строк
        Check_Columns(player, rating);        // проверка столбцов
        Check_Diagonal_Left(player, rating);        // проверка диагонали слева направо
        Check_Diagonal_Right(player, rating);        // проверка диагонали справа налево
    }
    private static void Point_Corners_Center() {
        if (BOARD[0][0] == EMPTY && BOARD[0][SIZE-1] == EMPTY && BOARD[SIZE-1][0] == EMPTY && BOARD[SIZE-1][SIZE-1] == EMPTY) {
            POINTS[0][0] = 4;
            POINTS[0][SIZE-1] = 4;
            POINTS[SIZE-1][0] = 4;
            POINTS[SIZE-1][SIZE-1] = 4;
        }
        if (BOARD[(SIZE-1)/2][(SIZE-1)/2] == EMPTY) POINTS[(SIZE-1)/2][(SIZE-1)/2] = 5;
    }

    // вспомогательные методы для процедуры Point_Equality
    private static void Check_Strings(char player, int rating) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (BOARD[i][j] == player) counter++;
            }
            if (counter == SIZE - 1) {
                for (int j = 0; j < SIZE; j++) {
                    if (POINTS[i][j] == 1) POINTS[i][j] += rating;
                }
            }
        }
    }
    private static void Check_Columns(char player, int rating) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (BOARD[j][i] == player) counter++;
            }
            if (counter == SIZE - 1) {
                for (int j = 0; j < SIZE; j++) {
                    if (POINTS[j][i] == 1) POINTS[j][i] += rating;
                }
            }
        }
    }
    private static void Check_Diagonal_Left(char player, int rating) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (BOARD[i][i] == player) counter++;
        }
        if (counter == SIZE - 1) {
            for (int i = 0; i < SIZE; i++) {
                if (POINTS[i][i] == 1) POINTS[i][i] += rating;
            }
        }
    }
    private static void Check_Diagonal_Right(char player, int rating) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (BOARD[i][SIZE-1-i] == player) counter++;
        }
        if (counter == SIZE - 1) {
            for (int i = 0; i < SIZE; i++) {
                if (POINTS[i][SIZE-1-i] == 1) POINTS[i][SIZE-1-i] += rating;
            }
        }
    }
}