package LEVEL_2.lesson_2;

class Summing {
    // ----------- GIVEN ----------------------------------------------------------------------------------
    private static String[][] arrString = new String[][]{
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"10","11", "12","е"},
            {"14","15","16","17"}};
    private static byte normalLength = 4;

    // ----------- OPERATIONS -----------------------------------------------------------------------------
    /**
     * Суммирует значения квадратного массива заранее заданной длинны параметром normalLength.
     * Проверяется соответствует ли длинна массива необходимому значению с помощью метода checkArraySize.
     * Проверяется есть ли в массиве не числовые значения с помощью метода sumString.
     * Складываются все значение массива между собой
     * @param arrString - входной строковый массив для вычисления суммы его значений
     * @throws MyArraySizeException - исклучение при длинне массива не равной заявленной
     *
     */
    static int sumString(String[][] arrString) throws MyArrayDataException {
        checkArraySize(arrString);
        int result = 0;
        for (int i = 0; i < arrString.length; i++) {
            for (int j = 0; j < arrString[0].length; j++) {
                if (arrString[i][j].matches("\\D"))
                    throw new MyArrayDataException((byte)i, (byte)j, arrString[i][j]);
                    else result += Integer.parseInt(arrString[i][j]);
            }
        }
        return result;
    }

    private static void checkArraySize(String[][] arrString) throws MyArraySizeException {
        if (arrString.length != normalLength) throw new MyArraySizeException((byte)0, (byte)arrString.length, normalLength);
        for (byte i = 0; i < arrString.length; i++) {
            if (arrString[i].length != normalLength) throw new MyArraySizeException(i, (byte)arrString[i].length, normalLength);
        }
    }

    // ----------- LAUNCH -------------------------------------------------------------------------------
    public static void main(String[] args) {
        try {
            System.out.println("Сумма значений строкового массива = " + sumString(arrString));
        }
        catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("массив № " + e.getArrNumber() + " - " + e.getArrLength() + " вместо " + normalLength);
            System.out.println("Просьба исправить массив и запустить заново программу.");
        }
        catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Не числовое значение заменено на 0");
            arrString[e.getI()][e.getJ()] = "0";
            System.out.println("Сумма значений строкового массива = " + sumString(arrString));
        }
    }
}


