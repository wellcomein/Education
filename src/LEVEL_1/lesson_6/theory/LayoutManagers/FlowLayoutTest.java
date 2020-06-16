package LEVEL_1.lesson_6.theory.LayoutManagers;

import javax.swing.*;
import java.awt.*;

/*
Менеджер FlowLayout размещает компоненты в контейнере слева направо и сверху вниз.
Данное расположение устанавливается по умолчанию в панелях JPanel.
FlowLayout определяет предпочтительный размер компонентов. Например, размер метки с текстом JLabel в соответствии с размером текста.
При последовательном расположении менеджер FlowLayout всегда сохраняет предпочтительный размер компонентов.
У FlowLayout есть еще одно важное свойство — оно действует при вызове методов preferredLayoutSize() или minimumLayoutSize(), позволяющих узнать предпочтительный и минимальный размеры контейнера, в котором менеджер действует. В этом случае метод возвращает размер, соответствующий ситуации расположения всех компонентов в одну строку. Это особенно важно при совмещении последовательного расположения с другими его вариантами. Благодаря этому свойству менеджеры других способов расположения будут стараться найти достаточно места для размещения компонентов в одну строку.
 */
public class FlowLayoutTest extends JFrame {
    private FlowLayoutTest() {
        super("FlowLayout");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(300, 120);
        // Панель содержимого
        Container container = getContentPane();
        /*
         * Определение последовательного расположения
         * с выравниванием компонентов по центру
         */
        container.setLayout (new FlowLayout(FlowLayout.CENTER));
        // добавляем компоненты
        container.add( new JButton("Школа" ));
        container.add( new JButton("Институт"));
        container.add( new JButton("Академия"));
        // Открываем окно
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}
