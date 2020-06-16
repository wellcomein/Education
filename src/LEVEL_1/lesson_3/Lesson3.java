package LEVEL_1.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
        /*
        Блок настроек игры
         */
        private static char[][] map; // матрица игры
        private static int SIZE = 3; // размерность поля

        private static final char DOT_EMPTY = ' ';  // пустой символ - свободное поле
        private static final char DOT_X = 'X';      // крестик
        private static final char DOT_O = 'O';      // нолик
        private static final boolean SILLY_MODE = false; // режим компьютера гений или чуть глуповат

        private static Scanner scanner = new Scanner(System.in);
        private static Random random = new Random();


        public static void main(String[] args) {
            initMap();
            printMap();

            while (true) {
                humanTurn();   // ход игрока
                if(isEndGame(DOT_X)) {
                    break;
                }


                computerTurn();   // ход компьютера
                if(isEndGame(DOT_O)) {
                    break;
                }
            }
            System.out.println("Игра окончена.");
        }

        /**
         * Метод подготовки игрового поля
         */
        private static void initMap() {
            map = new char[SIZE][SIZE];
            for(int i = 0; i < SIZE; i ++){
                for(int j = 0; j < SIZE; j++){
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        /**
         * Метод вывода игрового поля
         */
        private static void printMap() {
            for(int i = 0; i <= SIZE; i++){
                System.out.print(i + " ");
            }
            System.out.println();

            for(int i =0; i < SIZE; i++){
                System.out.print((i+1) + " ");
                for(int j = 0; j < SIZE; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }


        /**
         * Ход человека
         */
        private static void humanTurn() {
            int x, y;
            do {
                System.out.println("Введите координаты ячейки (X Y) через пробел");
                y = scanner.nextInt() - 1; // Считывание номера строки
                x = scanner.nextInt() - 1; // Считывание номера столбца
            }
            while(!isCellValid(x, y));

            map[y][x] = DOT_X;
        }


        /**
         * Метод валидации запрашиваемой ячейки на корректность
         * @param x - координата по горизонтали
         * @param y - координата по вертикали
         * @return boolean - признак валидности
         */
        public static boolean isCellValid(int x, int y){
            boolean result = true;

            // проверка координаты
            if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                result = false;
            }

            // проверка заполненности ячейки
            if(map[y][x] != DOT_EMPTY){
                result = false;
            }

            return result;
        }

        /**
         * Метод проверки игры на завершение
         * @param playerSymbol - символ, которым играет текущий игрок
         * @return - признак завершения игры
         */
        private static boolean isEndGame(char playerSymbol) {
            boolean result = false;

            printMap();

            // поверяем необходимость следующего хода
            if(checkWin(playerSymbol)) {
                System.out.println("Победили " + playerSymbol);
                result = true;
            }

            if(isMapFull()) {
                System.out.println("Ничья");
                result = true;
            }
            return result;
        }


        /**
         * Проверка на 100% заполняемость поля
         * @return boolean - признак оптимальности
         */
        private static boolean isMapFull() {
            boolean result = true;

            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(map[i][j] == DOT_EMPTY)
                        result = false;
                }
            }
            return result;
        }


        /**
         * Метод проверки выигрыша
         * @param playerSymbol - символ введённый пользователем
         * @return boolean - результат проверки
         */
        private static boolean checkWin(char playerSymbol) {
            boolean result = false;

            if(
                    (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                            (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                            (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                            (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                            (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                            (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                            (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                            (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)){
                result = true;
            }

            return result;
        }


        /**
         * Ход компьютера
         */


        private static void computerTurn(){
            int x = -1;
            int y = -1;

            if(SILLY_MODE){
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while(!isCellValid(x, y));
            }
            else{
                for(int i = 0; i < SIZE; i++){
                    for(int j = 0; j < SIZE; j++){
                        // Проверяем клетки по направлениям

                    }
                }
            }

            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            map[y][x] = DOT_O;
        }




    }
