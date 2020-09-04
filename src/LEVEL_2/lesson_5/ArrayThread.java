package LEVEL_2.lesson_5;

class ArrayThread extends Thread {
    float[] halfArray;
    int iForCount;      // Переменная нужна для того, чтобы во втором потоке в формуле i было не 0, а продолжение изначального массива. Так правильнее подсчёт.
    ArrayThread(float[] baseArray, int srcPos) {
        halfArray = new float[baseArray.length/2];
        System.arraycopy(baseArray, srcPos, this.halfArray, 0, baseArray.length/2);
        iForCount = srcPos;
        start();
    }
    @Override
    public void run() {
        for (int i = 0; i < halfArray.length; i++, iForCount++) {
            halfArray[i] = (float)(halfArray[i] * Math.sin(0.2f + iForCount / 5) * Math.cos(0.2f + iForCount / 5) * Math.cos(0.4f + iForCount / 2));
        }
    }
    float[] getHalfArray() {
        return halfArray;
    }
}
