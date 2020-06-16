package LEVEL_1.lesson_6.check_HT.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator2
{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class CalculatorFrame extends JFrame {
    CalculatorFrame() {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}

class CalculatorPanel extends JPanel {
    CalculatorPanel() {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start=true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("4", insert);

        addButton("5", insert);
        addButton("6", insert);
        addButton("7", insert);
        addButton("8", insert);

        addButton("9", insert);
        addButton("0", insert);
        addButton("00", insert);
        addButton("+", command);
        addButton("-", command);

        addButton("*", command);
        addButton("=", command);

        addButton("C", command);



        add(panel, BorderLayout.CENTER);
    }
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if(start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            if(start)
            {
                if(command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else lastCommand = command;
            }
            else
            {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start=true;
            }
        }
    }
    private void calculate(double x)
    {
        switch (lastCommand) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                result /= x;
                break;
            case "=":
                result = x;
                break;
            case "C":
                result = 0;
                break;
        }
        display.setText("" + result);
    }
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
}