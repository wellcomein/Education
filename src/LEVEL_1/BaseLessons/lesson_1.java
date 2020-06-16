package LEVEL_1.BaseLessons;

import java.util.Scanner;

public class lesson_1 {
    public static void main(String[] args) {
        Calculator(AskPlayer(),10,20);
    }
    private static void Calculator(char symbol, int symbol1, int symbol2) {
        int result = 0;
        switch (symbol) {
            case '+': result = symbol1 + symbol2; break;
            case '-': result = symbol1 - symbol2; break;
            case '*': result = symbol1 * symbol2; break;
            case '/': result = symbol1 / symbol2; break;
            default: System.out.println("Something wrong"); break;
        }
        System.out.println("Answer: " + symbol1 + symbol + symbol2 + "=" + result);
    }
    private static char AskPlayer () {
        char answer;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter sign: ");
            answer = scanner.next().charAt(0);
            if (answer == '+' || answer == '-' || answer == '*' || answer == '/') break;
        }
        scanner.close();
        return answer;
    }
}
