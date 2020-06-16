package LEVEL_1.lesson_1;

import java.util.Scanner;
/*
1. Создать пустой проект в IntelliJ IDEA и прописать метод main();

2. Создать переменные всех пройденных типов данных, и инициализировать их значения;

3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;

4. Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;

5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);

6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;

7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;

8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

9. *Не набирая код в IDE, ответьте на следующий вопрос. Есть два метода:

void myMethod(int a, String b) {}
void myMethod(String b, int a) {}

Это две разных сигнатуры одного метода или один и тот же метод?
 */

public class HomeTask_1 {

    public static void main(String[] args) {
        
        System.out.println("Здравствуйте! Это домашнее задание к уроку 1 курса Основы Java. Интерактивный курс.");

        System.out.println("1. Пустой проект в IntelliJ IDEA с прописанным методом main() создан.");

        getNumders();   // процедура содержит переменные всех пройденных типов данных

        System.out.println("3. Расчёт формулы a * (b + (c / d)) по введённым пользователем переменным:");
        System.out.println("Ответ: " + getCount(parseInt(),parseInt(),parseInt(),parseInt()));

        System.out.println("4. Сумма двух чисел лежит в пределах от 10 до 20 (включительно)?");
        System.out.println("Ответ: " + getPoint(parseInt(),parseInt()));

        getPositive(5);  // Необходимо ввести целое число, а процедура подскажет положиельное оно или отрицательное

        System.out.println("6. Если введённое целое число отрицательное, то вернётся true: " + getNegative(-10));

        System.out.print("7. ");
        getName("Вова");

        getYear(2018);   // Необходимо ввести год, а процедура подскажет високосный это год или нет

        System.out.println("9. Методы void myMethod(int a, String b) {} и void myMethod(String b, int a) {} - это один и тот же метод.");
    }

    static void getNumders() {
        byte byt = 120;
        short sho = 1200;
        int in = 12000;
        long lon = 120000L;
        float flo = 12.5f;
        double dou = 120.5;
        boolean boo = false;
        char cha = 'B';
        String text = "Текстовая переменная";
        System.out.println("2. Созданы переменные всех пройденных типов данных, и инициализированы их значения:");
        System.out.println(byt + "; " + sho + "; " + in + "; " + lon + "; " + flo + "; " + dou + "; " + boo + "; " + cha + "; " + text);
    }

    static int getCount(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    static boolean getPoint(int arg1, int arg2) {
        int sum = arg1 + arg2;
        boolean check = false;
        if((sum >= 10) && (sum <= 20)) {
            check = true;
        }
        return check;
    }

    static void getPositive(int q) {
        if(q < 0) {
            System.out.println("5. Введённое число " + q + " отрицательное.");
        }
        else {
            System.out.println("5. Введённое число " + q + " положительное.");
        }
    }

    static boolean getNegative(int w) {
        boolean an = false;
        if(w < 0) {
            an = true;
        }
        return an;
    }

    static void getName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    static void getYear(int year) {
        if((year % 4 == 0) && (year % 100 != 0)) {
            System.out.println("8. " + year + " год високосный.");
        }
        else if((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
            System.out.println("8. " + year + " год високосный.");
        }
        else {
            System.out.println("8. " + year + " год невисокосный.");
        }
    }

    static int parseInt() {
        Scanner myInput = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int num = myInput.nextInt();
        return num;
    }
}

