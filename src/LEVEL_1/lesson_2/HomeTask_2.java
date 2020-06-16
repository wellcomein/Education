package LEVEL_1.lesson_2;

import java.util.Arrays;

public class HomeTask_2 {
    public static void main(String[] args) {
        System.out.println("Здравствуйте! Вы видите выполнение задания к уроку 2 курса Основы Java. Интерактивный курс.");
/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
С помощью цикла и условия заменить 0 на 1, 1 на 0;
*/
        System.out.println("\n1. Покорно задаю целочисленный массив с обозначенными в задании элементами и меняю их значения.");
        int[] arr1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Изначальный массив состоит из следующих значений: " + Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == 1) arr1[i] = 0;
            else arr1[i] = 1;
        }
        System.out.println("Изменённый массив состоит из следующих значений: " + Arrays.toString(arr1));



//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("\n2. Со всем уважением задаю целочисленный массив и заполняю его значениями:");
        int[] arr2 = new int[8];
        int k = 0;
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = k;
            k += 3;
        }
        System.out.println("Заполненный массив выглядит так: " + Arrays.toString(arr2));


// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
        System.out.println("\n3. Задаю массив и заполняю его значениями, а числа меньшие 6 умножаю на 2:");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Изначальный массив состоит из следующих значений: " + Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i] < 6) arr3[i] *= 2;
        }
        System.out.println("Изменённый массив состоит из следующих значений: " + Arrays.toString(arr3));


// 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("\n4. Задаю двумерный массив и рисую крестик из единичек:");
        int a = 10; // Количество строк/столбцов в массиве
        int[][] arr4 = new int[a] [a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if((i == j) ||(i == (a - j - 1))) arr4[i][j] = 1;
                System.out.print(arr4[i][j]);
                if(j == (a - 1)) System.out.println();
            }
        }


// 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("\n5. Обещаю без помощи интернета создать массив и найти в нем максимальный и минимальный элементы:");
        int i = 0;
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr5[0];
        int max = arr5[0];
        while (i < arr5.length - 1) {
            if (arr5[i+1] < min) min = arr5[i+1];
            if (arr5[i+1] > max) max = arr5[i+1];
            ++i;
            }
        System.out.println("Минимальное значение в массиве " + min + "\nМаксимальное значение в массиве " + max);


/*
6. Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
граница показана символами ||, эти символы в массив не входят;
*/
    int[] arr6 = {2, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    System.out.println("\n6. Проверить равны ли сумма левой и правой части массива " + Arrays.toString(arr6));
    System.out.println("Ответ: " + checkBalance(arr6));


/*
7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.
*/
    System.out.println("\n7. Сместим-ка значения массива на n позиций, не изменяя при этом количество элементов массива (если я правильно понял задание).");
    makeShift(arr6, -3);
    }


    static boolean checkBalance(int[] arr) {
        int sumR = 0;
        for (int i = arr.length-1; i > 0; i--) {
            sumR = sumR + arr[i];
            int sumL = 0;
            for (int j = 0; j < arr.length - 1; j++) {
                sumL = sumL + arr[j];
                if ((sumR == sumL) && (i > j)) return true;
            }
        }
        return false;
    }

    static void makeShift(int[] arr, int n) {
        System.out.println("Изначальный массив состоит из следующих значений: " + Arrays.toString(arr));
        if (n < 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i - n < arr.length) arr[i] = arr[i - n];
                if (i >= (arr.length + n)) arr[i] = 0;
            }
        }
        else {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (j - n > 0) arr[j] = arr[j - n];
                if (j < n) arr[j] = 0;
            }
        }
        System.out.println("Изменённый массив состоит из следующих значений: " + Arrays.toString(arr));
    }
}
