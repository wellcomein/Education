package LEVEL_1.lesson_6.theory.FirstSteps;

import javax.swing.*;
import java.awt.*;

// 1. Создание простого окна с заранее написанным текстовым полем
public class SimpleJFrame {
    private static void createGUI() {

        // Создаёт пустое окно с заголовком "Test frame"
        JFrame frame = new JFrame("Test frame");

        // действие при закрытии программы - закрыть окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel label = new JLabel("Test lable");
        frame.getContentPane().add(label);

        // задаются размеры окна
        frame.setPreferredSize(new Dimension(200,100));

        frame.pack();

        // в конце выполненя програмы делаем окно видимым
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        // отключаем системную стилизацию окна и включаем стилизацию по умолчанию в swing
        JFrame.setDefaultLookAndFeelDecorated(true);

        // при помощи нового потока запускаем приложение
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
