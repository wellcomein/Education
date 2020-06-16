package LEVEL_1.lesson_6.theory.Events;

import javax.swing.*;

// Выводит после нажатия ENTER в консоль текст написанный в поле
public class FieldType extends JFrame {
    private FieldType() {
        setBounds(500, 500, 400, 300);
        setTitle("Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField field = new JTextField();
        add(field);
        field.addActionListener(e -> System.out.println("Your message: " + field.getText()));
        setVisible(true);
    }

    public static void main(String[] args) {
        new FieldType();
    }
}