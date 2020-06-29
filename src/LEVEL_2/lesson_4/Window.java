package LEVEL_2.lesson_4;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.lightGray;

/**
 * Класс Окно отрисовывает окно.
 * В качестве праметра класса созается ссылка на объект класса Компонент,
 * в котором создаются и пропиписываются методы кнопки, многострочного, однострочного полей.
 */
class Window extends JFrame {
    private Component component = new Component();

    Window() {
        setTitle("What a simple messenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,500,500);
        setLayout(new BorderLayout());

        Panel upPanel = new Panel(component.getTextScrollArea());
        Panel downPanel = new Panel(component.getTextField(), component.getButton());
        add(upPanel, BorderLayout.CENTER);
        add(downPanel, BorderLayout.PAGE_END);

        setVisible(true);
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}
