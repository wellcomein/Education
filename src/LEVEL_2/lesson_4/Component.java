package LEVEL_2.lesson_4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Component extends JComponent {
    private JTextArea textArea = new JTextArea();
    private JTextField textField = new JTextField();
    private JButton button = new JButton("Send");

    Component() {
        textArea.setEnabled(false);
        textListener(textField);
        buttonListener(button);

    }

    JScrollPane getTextScrollArea() {
        return new JScrollPane(textArea);
    }
    JTextField getTextField() {
        return textField;
    }
    JButton getButton() {
        return button;
    }

    private void textListener(JTextField component) {
        component.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(component.getText() + "\n");
                component.setText("");
            }
        });
    }
    private void buttonListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
            }
        });

    }
}
