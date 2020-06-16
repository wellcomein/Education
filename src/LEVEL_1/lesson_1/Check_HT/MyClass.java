package LEVEL_1.lesson_1.Check_HT;

public class MyClass {
    public static void main(String[] args) {
        byte a = 10;
        short b = 32000;
        char c = 255;
        int d = 252552;
        long e = 34343434l;
        float f = 1.3f;
        double g = 4.54545d;
        boolean flag = true;

        System.out.println("Hello, World!");
        System.out.println(calc(a,5,6,1));
        System.out.println(task4(15,3));
        task5(-5);
        System.out.println(task6(-10));
        greet("Влад");
        System.out.println(task8(79));
    }
    static double calc(int a,int b, int c,int d){
        return a*(b+(c/d));
    }
    static boolean task4(int e,int f){
        if (e+f>=10 && e+f<=20) return true;
        else return false;
    }
    static void task5(int num){
        if (num>=0){
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
    static boolean task6(int vr){
        if (vr<0) return true;
        return false;
    }
    static void greet(String name){
        System.out.println("Привет, " + name + "!");
    }
    static boolean task8(int year){
        if ( (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        }
        return false;
    }
}
