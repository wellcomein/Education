package LEVEL_2.lesson_2;

class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    private byte arrNumber;
    private byte arrLength;
    public MyArraySizeException(byte arrNumber, byte arrLength, byte normalLength) {
        super("Размер массива выходит за необходимое занечение: массив № "
                +(arrNumber + 1) + " - " + arrLength + " вместо " + normalLength);
        this.arrNumber = arrNumber;
        this.arrLength = arrLength;
    }

    byte getArrNumber() {
        return arrNumber += 1;
    }
    byte getArrLength() {
        return arrLength;
    }
}
