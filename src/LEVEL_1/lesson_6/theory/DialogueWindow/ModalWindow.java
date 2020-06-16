package LEVEL_1.lesson_6.theory.DialogueWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/*
Для всплывающих окон применяется JOptionPane. Этот класс наследуется от JComponent.
*/

// Создание всплывающих окон
public class ModalWindow {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("Окно вывода сообщений");
        // определяем размер окна
        frame.setSize(260,150);
        // что будет происходить при закрытии программы
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём панель с менеджером вертикального расположения окон
        JPanel contents = new JPanel(new FlowLayout());
        // Создаём кнопку
        JButton button1 = new JButton("Modal Window");
        JButton button2 = new JButton("Error Window");

        // Создаём слушателя который будет выводить всплывающее окно с текстом
        ActionListener listener1 = e -> {
            // В строчке ниже "content" - элемент относительно которого будет привязываться это окно
            JOptionPane.showMessageDialog(contents, "<html><h2>Текст</h2><i>обычное диалоговое окно HTML</i>");
        };
        ActionListener listener2 = e -> {
            // В строчке ниже "content" - элемент относительно которого будет привязываться это окно
            JOptionPane.showMessageDialog(contents,
                    new String[] {"Сообщение в виде массива строк :",
                            " - первая строка",
                            " - вторая строка"},
                    "Ошибка!",
                    JOptionPane.ERROR_MESSAGE);
        };

        button1.addActionListener(listener1);
        contents.add(button1);
        button2.addActionListener(listener2);
        contents.add(button2);

        frame.setContentPane(contents);
        frame.setVisible(true);
    }
}
