package LEVEL_1.lesson_6.check_HT.two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {
    private ActionEvent e;
    private int currentOperation = 0;
    private double result = 0;

    private final int RESET = 0; // Сброс
    private final int PLUS = 1; // Сложение
    private final int MINUS = 2; // Вычитание
    private final int MULTIPLY = 3; // Умножение
    private final int DIVISION = 4; // Деление
    private final int POW = 5; // Возведение в степень




    private Calculator() {
        super("Calculator 1.0 by Dmitry Yakubov @ GeekBrains");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();

        //Поле ввода-вывода
        JTextField field = new JTextField(10);
        field.setPreferredSize(new Dimension(350, 50));
        field.requestFocus();
        field.setFont(new Font("Field", Font.PLAIN, 24));
        container.add(field, BorderLayout.NORTH);

        //Сетка кнопок
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(2, 2, 5, 12);
        grid.setLayout(layout);
        container.add(grid, BorderLayout.SOUTH);

        setSize(350, 200);

        // Создаем кнопки
        JButton plus = new JButton("+");
        plus.setPreferredSize(new Dimension(50,50));

        JButton minus = new JButton("-");
        plus.setPreferredSize(new Dimension(50,50));

        JButton multiply = new JButton("*");
        plus.setPreferredSize(new Dimension(50,50));

        JButton division = new JButton("/");
        plus.setPreferredSize(new Dimension(50,50));

        JButton pow = new JButton("^");
        plus.setPreferredSize(new Dimension(50,50));

        JButton getResult = new JButton("=");
        plus.setPreferredSize(new Dimension(50,50));

        JButton reset = new JButton("C");
        plus.setPreferredSize(new Dimension(50,50));


        //Кнопка сброса
        grid.add(reset);
        reset.setBackground(Color.GRAY);
        reset.addActionListener(e -> {
            field.setText(""); //Очищаем поле ввода-вывода
            currentOperation = RESET; // Добавляем идентификатор операции (в данном случае не используется)
            result = 0; // Обнуляем результат
            field.requestFocus(); // Возвращаем курсор на поле ввода-вывода

        });

        //Кнопка сложения
        grid.add(plus);
        plus.addActionListener(e -> {
            double a = Double.parseDouble(field.getText()); // вводим переменную, в которую записываем введенное в поле ввода-вывода значение
            result = a;
            field.setText("");
            currentOperation = PLUS;
            field.requestFocus();
        });


        grid.add(minus);
        minus.addActionListener(e -> {
            double a = Double.parseDouble(field.getText());
            result = a;
            field.setText("");
            currentOperation = MINUS;
            field.requestFocus();

        });

        grid.add(multiply);
        multiply.addActionListener(e -> {
            double a = Double.parseDouble(field.getText());

            result = a;
            field.setText("");
            currentOperation = MULTIPLY;
            field.requestFocus();

        });

        grid.add(division);
        division.addActionListener(e -> {
            double a = Double.parseDouble(field.getText());
            result = a;
            field.setText("");
            currentOperation = DIVISION;
            field.requestFocus();

        });

        grid.add(pow);
        pow.addActionListener(e -> {
            double a = Double.parseDouble(field.getText());

            result = a;
            field.setText("");
            currentOperation = POW;
            field.requestFocus();

        });



        grid.add(getResult);
                getResult.addActionListener(e -> {

                    double b = Double.parseDouble(field.getText());
                    //Проверяем, что не происходит деление на ноль
                    if (b == 0.0 && currentOperation == DIVISION) {
                        JOptionPane.showMessageDialog(Calculator.this, "На ноль делить нельзя", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        field.setText("");
                        result = 0;
                        field.requestFocus();
    //
                    } else {
                        double res = getResult (result, b, currentOperation);
                        //Проверяем дробную часть, если равно нулю, то выводим значение без дробной части
                        if (res - (int)res != 0){
                            field.setText(String.valueOf(res));
                        } else {
                            field.setText(String.valueOf((int)res));
                        }
                    }

                });


        setVisible(true);

    }

    private double getResult(double a, double b, int operation) {
        double result = 0;
        switch (operation) {
            // Сложение
            case PLUS:
                result = a + b;
                break;

            // Вычитание
            case MINUS:
                result = a - b;
                break;

            // Умножение
            case MULTIPLY:
                result = a * b;
                break;

            // Деление
            case DIVISION:
                result = a / b;
                break;

            // Возведение в степень
            case POW:
                result = (Math.pow(a, b));
                break;

        }

        return result;
    }

    public static void main(String[] args) {
        //setDefaultLookAndFeelDecorated(true);
        new Calculator();
    }
}
