package LEVEL_1.lesson_6.homeTask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator {

    // Переменные для расчёта
    private static double Arg1;
    private static double Arg2;
    private static double Result;

    public static void main(String[] args) {
        MyWindow();
    }

    private static void MyWindow() {
        // Создаём окно
        JFrame frame = new JFrame("Calculator");

        // Определяем размеры
        frame.setSize(230,290);

        // Указываем, что при закрытииокна выходим из програмы
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contents = new JPanel();

        // Оформление калюкулятора. Добавление текста, полей и кнопок
        contents.add(new JLabel("Please enter the first value"));
        JTextField arg1 = new JTextField(17);
        contents.add(arg1);

        contents.add(new JLabel("Please enter the second value"));
        JTextField arg2 = new JTextField(17);
        contents.add(arg2);

        contents.add(new JLabel("Please choose operation"));
        JButton button1 = new JButton("+");
        JButton button2 = new JButton("-");
        JButton button3 = new JButton("х");
        JButton button4 = new JButton("/");
        JButton button5 = new JButton("^");
        JButton button6 = new JButton("=");
        contents.add(button1);
        contents.add(button2);
        contents.add(button3);
        contents.add(button4);
        contents.add(button5);
        contents.add(button6);

        arg1.addActionListener(e -> Arg1 = Double.parseDouble(arg1.getText()));
        arg2.addActionListener(e -> Arg2 = Double.parseDouble(arg2.getText()));


        // Создаём слушателя при суммировании
        ActionListener listener1 = new ActionListener() {
            // В теле этого метода задаётся поведение при нажатии на кнопку
            @Override
            public void actionPerformed(ActionEvent e) {
                Result = Arg1+Arg2;
            }
        };
        // Создаём слушателя при вычитании
        // В теле этого метода задаётся поведение при нажатии на кнопку
        ActionListener listener2 = e -> Result = Arg1-Arg2;
        // Создаём слушателя при умножении
        // В теле этого метода задаётся поведение при нажатии на кнопку
        ActionListener listener3 = e -> Result = Arg1*Arg2;
        // Создаём слушателя при делении
        // В теле этого метода задаётся поведение при нажатии на кнопку
        ActionListener listener4 = e -> Result = Arg1/Arg2;
        // Создаём слушателя при возведении в степень
        ActionListener listener5 = e -> {
            Result = Arg1;
            for (int i = 1; i < Arg2; i++) {
                Result *= Arg1;
            }
        };
        ActionListener listener6 = e -> {
            System.out.println("Result: " + Result);
            JOptionPane.showMessageDialog(contents, Result,"Result:", JOptionPane.INFORMATION_MESSAGE);
        };

        // Устанавливаем слушателя
        button1.addActionListener(listener1);
        button2.addActionListener(listener2);
        button3.addActionListener(listener3);
        button4.addActionListener(listener4);
        button5.addActionListener(listener5);
        button6.addActionListener(listener6);

        // Размещаем панель в контейнере
        frame.setContentPane(contents);

        // Делаем окно видимым
        frame.setVisible(true);
    }
}
