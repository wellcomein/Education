package LEVEL_1.lesson_6.theory.LayoutManagers;

import javax.swing.*;
import java.awt.*;

// Одновременне использование Грид и Флоу менеджера
public class GridAndFlowLayoutTest extends JFrame {
    private GridAndFlowLayoutTest() {
        super("GridAndFlowLayoutTest");
        setSize(320, 240);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Создание панели с табличным расположением
        JPanel grid = new JPanel(new GridLayout(1,2,5,0));

        // Добавление кнопок в панель
        grid.add(new JButton("OK"));
        grid.add(new JButton("Cancel"));

        // Создание панели с последовательным расположением
        // компонентов и выравниванию по левому краю
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Добавляем в панельку Флоу ранее созданную панель с кнопками Грид
        flow.add(grid);

        // Получение панели содержимого
        Container container = getContentPane();

        // Размещение панели с кнопками внизу справа
        container.add(flow, BorderLayout.SOUTH);

        // Открываем окно
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridAndFlowLayoutTest();
    }
}
