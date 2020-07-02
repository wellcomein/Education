package LEVEL_2.lesson_5;

import java.util.Arrays;

class MyArray {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    private static float[] array = new float[SIZE];

    public static void main(String[] args) {
        printResult(method_1(getArray()));
        printResult(method_2(getArray()));
    }
    static float[] getArray () {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        return array;
    }
    private static synchronized long method_1(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
//        System.out.println(Arrays.toString(arr));
        return System.currentTimeMillis() - a;
    }
    private static long method_2(float[] arr) {
        long a = System.currentTimeMillis();
        ArrayThread arrayThread1 = new ArrayThread(arr,0);
        ArrayThread arrayThread2 = new ArrayThread(arr, HALF);
        System.arraycopy(arrayThread1.getHalfArray(), 0, arr, 0, arrayThread1.getHalfArray().length);
        System.arraycopy(arrayThread2.getHalfArray(), 0, arr, HALF, arrayThread2.getHalfArray().length);
//        System.out.println(Arrays.toString(arr));
        return System.currentTimeMillis() - a;
    }
    private static void printResult(Object object) {
        System.out.println("Вычисления в методе 1 заняли " + object + " миллисекунд.");
    }
}
