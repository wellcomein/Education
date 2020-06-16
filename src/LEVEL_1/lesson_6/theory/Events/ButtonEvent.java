package LEVEL_1.lesson_6.theory.Events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Создаёт действие при нажатии кнопки
public class ButtonEvent {

    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("Maring event botton");

        // Определение размера окна
        frame.setSize(260, 150);

        // Операция при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём панель с менеджером вертикального расположения компонентов
        JPanel content = new JPanel(new FlowLayout());

        // Создаём кнопку
        JButton button = new JButton("Event");

        // Добавляем кнопку в панель
        content.add(button);

        // Создаём слушателя
        // В теле этого метода задаётся поведение при нажатии на кнопку
        ActionListener listener = e -> {
            System.out.println("Button pressed...");
            // Можно играть дополнительными параметрами или узнать дополнительную информацию напечатав e., а дальше появятся возможные варианты
            e.getWhen(); // узнаёт когда была нажата кнопка
        };

        // Устанавливаем слушателя
        button.addActionListener(listener);

        // Размещаем панель в контейнер
        frame.setContentPane(content);

        // Открываем окно
        frame.setVisible(true);
    }
}
