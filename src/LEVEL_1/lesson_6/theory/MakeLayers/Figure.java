package LEVEL_1.lesson_6.theory.MakeLayers;

import javax.swing.*;
import java.awt.*;

// Класс JComponent отвечает за создание фигур и объектов на поле
public class Figure extends JComponent
{
    private Color color;
    private int type; // 0 - круг, 1 - прямоугольник

    // параметры: цвет и тип фигуры
    Figure(Color color, int type, String text) {
        this.color = color;
        this.type = type;
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        // прорисовка фигуры. Рисует цветом фигуру
        g.setColor(color);
        switch (type) {
            case 0: g.fillOval(0, 0, 90, 90); break;
            case 1: g.fillRect(0, 0, 130, 80); break;
        }
    }
}
