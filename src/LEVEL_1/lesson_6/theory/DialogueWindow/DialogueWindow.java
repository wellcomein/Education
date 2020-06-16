package LEVEL_1.lesson_6.theory.DialogueWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Создание диалогового ока, где пользователь что-то отвечает
public class DialogueWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(260,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contents = new JPanel(new FlowLayout());
        JButton button = new JButton("Event field");
        JButton btnConfirm1 = new JButton("Event confirm");
        JButton btnConfirm2 = new JButton("Event confirm warning");
        JButton btnInput1 = new JButton("Event field");
        JButton btnInput2 = new JButton("Event field");

        // Сам метод и его описание ниже
        addConfirmListeners(btnConfirm1, btnConfirm2, contents);
        // Сам метод и его описание ниже
        addInputListeners(btnInput1, btnInput2, contents);

        ActionListener listener = e -> {
            String result = JOptionPane.showInputDialog(contents, "<html><h2>Добро пожаловать</h2><p>Ваше имя?</p>");
            JOptionPane.showInputDialog(contents, "Вы ввели", result);
        };

        button.addActionListener(listener);
        contents.add(button);
        contents.add(btnConfirm1);
        contents.add(btnConfirm2);
        contents.add(btnInput1);
        contents.add(btnInput2);

        frame.setContentPane(contents);
        frame.setVisible(true);
    }

    // Диалоговые окна подтверждений ConfirmDialog
    private static void addConfirmListeners(JButton btnConfirm1, JButton btnConfirm2, JPanel contents)
    {
        btnConfirm1.addActionListener(e -> {
            // Окно подтверждения c четырьмя параметрами
            int result = JOptionPane.showConfirmDialog(
                    contents,
                    "Вам это нужно?",
                    "Question",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION)
                JOptionPane.showConfirmDialog(contents,
                        "Вы не отказываетесь?");
            else if (result == JOptionPane.NO_OPTION)
                JOptionPane.showConfirmDialog(contents,
                        "Вы отказались?");
        });
        btnConfirm2.addActionListener(e -> JOptionPane.showConfirmDialog(contents,
                "Вы не отказываетесь?",
                "Warning!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE));
    }

    // Диалоговые окна выбора данных InputDialog
    private static void addInputListeners(JButton btnInput1, JButton btnInput2, JPanel contents)
    {
        btnInput1.addActionListener(e -> {
            // Диалоговое окно ввода данных: родитель, HTML-сообщение
            String result = JOptionPane.showInputDialog(
                    contents,
                    "<html><h2>Добро пожаловать");
            JOptionPane.showInputDialog(contents,
                    "Вы ответили", result);
        });
        btnInput2.addActionListener(e -> {
            // Диалоговое окно ввода данных: родитель, сообщение в виде
            // массива строк, тип диалогового окна (иконки)
            JOptionPane.showInputDialog(contents,
                    new String[] {"Неверно введен пароль!",
                            "Повторите пароль :"},
                    "Авторизация",
                    JOptionPane.WARNING_MESSAGE);
        });
    }


}
