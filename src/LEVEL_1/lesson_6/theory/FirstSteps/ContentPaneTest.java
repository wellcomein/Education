package LEVEL_1.lesson_6.theory.FirstSteps;

import javax.swing.*;

/*
В примере создается небольшое окно и панель с двумя кнопками, которая затем методом setContentPane() заменяет панель содержимого окна.
Здесь замена используется вместо более простого добавления — вызовом метода add().
 */
public class ContentPaneTest extends JFrame {
    private ContentPaneTest()
    {
        super("Test ContentPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Создание панели с двумя кнопками
        JPanel contents = new JPanel();
        contents.add(new JButton("Java"));
        contents.add(new JButton("PHP"));

        // Замена панели содержимого
        setContentPane(contents);

        // Определение размера окна
        setSize(200, 100);

        // Открытие окна
        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ContentPaneTest();
    }
}
