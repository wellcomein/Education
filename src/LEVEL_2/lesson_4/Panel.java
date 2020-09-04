package LEVEL_2.lesson_4;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.lightGray;

/**
 * Класс создания панелей для окна и их настроек.
 */
class Panel extends JPanel{
    Panel(JComponent component) {
        setLayout(new BorderLayout());
        add(component);
    }
    Panel(JComponent component1, JComponent component2) {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.9;             // поле занимает 90% строчки
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(component1, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;             // кнопка занимает 10% срочки
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(component2, gridBagConstraints);
        setBackground(lightGray);
    }
}
