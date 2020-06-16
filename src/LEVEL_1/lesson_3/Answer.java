package LEVEL_1.lesson_3;

public class Answer {
    int SIZE = 3;
    char map[][];
    char DOT_EMPTY = '.';
    char DOT_O = 'O';
    int x;
    int y;



    // алгоритм с подсчётом очков
    private void SmartComputer() {
        int maxScoreFieldX = -1;
        int maxScoreFieldY = -1;
        int maxScore = 0;

        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                int fieldScore = 0;
                if (map[i][j] == DOT_EMPTY) {
                    //　проверяем направления
                    // left up
                    if(i - 1 >= 0 && j - 1 >= 0 && map[i-1][j-1] == DOT_O) fieldScore++;
                    // up
                    if ( i - 1 >= 0 && map[i-1][j] == DOT_O) fieldScore++;
                    // right up
                    if (i - 1 >=0 && j+1 < SIZE && map[i-1][j+1] == DOT_O) fieldScore++;
                    // right
                    if (j + 1 < SIZE && map[i][j+1] == DOT_O) fieldScore++;
                    // right down
                    if (i + 1 < SIZE && j + 1 < SIZE && map[i+1][j+1] == DOT_O) fieldScore++;
                    // down
                    if (i + 1 < SIZE && map[i+1][j] == DOT_O) fieldScore++;
                    // left down
                    if (i + 1 <SIZE && j - 1 >= 0 && map[i+1][j-1] == DOT_O) fieldScore++;
                    // left
                    if (j-1 >=0 && map[i][j-1] == DOT_O) fieldScore++;
                }
                if (fieldScore > maxScore) {
                    maxScore = fieldScore;
                    maxScoreFieldX = j;
                    maxScoreFieldY = i;

                }
            }
        }
        // если в цикле найдена наилучшая клетка
        if (maxScore != -1) {
            x = maxScoreFieldX;
            y = maxScoreFieldY;
        }
    }
    // если ничего не нашли, делаем глупый ход
    // дальше код для рандома
}
