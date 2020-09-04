package LEVEL_2.lesson_2;

class MyArrayDataException extends IllegalArgumentException {
    private byte i;
    private byte j;

    public MyArrayDataException(byte i, byte j, String value) {
        super("В ячеёке массива " + "["+ i +"]" + "[" + j + "]" + " находится не числовое значение - " + value);
        this.i = i;
        this.j = j;
    }

    byte getI() {
        return i;
    }
    byte getJ() {
        return j;
    }
}