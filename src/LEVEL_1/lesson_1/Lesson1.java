package LEVEL_1.lesson_1;

import java.util.Scanner;
// Подключаем возможность вводить пользователем данные


public class Lesson1 {

    // Объявляем основной метод. Без него нельзя
    public static void main(String[] arc) {

        // ----------
        // Создаём калькулятор. Начало програмы.
        double argument1 = readDoubleArgument("Введите первый аргумент: ");
        double argument2 = readDoubleArgument("Введите второй аргумент: ");
        String operation = readStringArgument("Введите операцию [+, -, /, *]: ");

        if(validateCalculationData(operation)){
            calculate(operation, argument1, argument2);
        }
    }

    static double readDoubleArgument(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        double argument = userInput.nextDouble();
        return argument;
    }

    static String readStringArgument(String userText){
        Scanner userInput = new Scanner(System.in);
        System.out.print(userText);
        String argument = userInput.nextLine();
        return argument;
    }

    static boolean validateCalculationData(String operation){
        boolean result = true;

        if(!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*")) {
            System.err.println("Введена недопустимая операция");
            result = false;
        }

        return result;
    }

    static void calculate(String operation, double arg1, double arg2){
        switch(operation){
            case "+":
                System.out.println(arg1 + arg2);
                break;
            case "-":
                System.out.println(arg1 - arg2);
                break;
            case "/":
                System.out.println(arg1 / arg2);
                break;
            case "*":
                System.out.println(arg1 * arg2);
                break;
        }
    }
    // Создаём калькулятор. Конец програмы.
    // ----------

}
