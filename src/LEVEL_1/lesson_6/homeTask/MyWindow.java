package LEVEL_1.lesson_6.homeTask;

import javax.swing.*;

class MyWindow {

    static void myWindow() {
        // Создаём окно
        JFrame myWindow = new JFrame("My calculator v. 2.0");
        // Задаём размер окна
        myWindow.setSize(200,200);
        // Операция при закрытии окна
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём поле кнопок с числами
        JPanel numPad = new JPanel();
        JPanel symbolPad = new JPanel();

        // Размещение поля в окне
        myWindow.setContentPane(numPad);
        myWindow.setContentPane(symbolPad);
        // Сделать окно видимым
        myWindow.setVisible(true);
    }
}
