package LEVEL_1.lesson_6.theory.LayoutManagers;

import javax.swing.*;
import java.awt.*;

/*
Менеджер BoxLayout позволяет настраивать размещение компонентов в вертикальном или в горизонтальном направлении и управлять пространством между компонентами, используя вставки.
Для размещения компонентов в вертикальной плоскости необходимо передать конструктору константу BoxLayout.Y_AXIS, в горизонтальной — BoxLayout.X_AXIS.
 */
public class BoxLayoutTest
{
    /**
     * Процедура добавления кнопки в контейнер
     * @param caption заголовок кнопки
     * @param container контейнер
     */
    private static void addButton(String caption, Container container)
    {
        JButton button = new JButton(caption);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
    /**
     * Процедура создания интерфейса формы
     * @param container контейнер
     */
    private static void createUI(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        addButton("Хлеб" , container);
        addButton("Молоко" , container);
        addButton("Колбасы" , container);
        addButton("Мясо и птица", container);
        addButton("Замороженные продукты", container);
    }

    public static void main(String[ ] args){
        // Создание окна
        final JFrame frame = new JFrame("BoxLayoutTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Определение интерфейса окна
        createUI(frame.getContentPane());
        SwingUtilities.invokeLater(() -> {
            // Открытие окна
            frame.pack();
            frame.setVisible(true);
        });
    }
}
