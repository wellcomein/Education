package LEVEL_1.lesson_6.theory.LayoutManagers;

import javax.swing.*;

public class VLTest {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame();

        // Определяем размеры
        frame.setSize(260,150);

        // Указываем, что при закрытииокна выходим из програмы
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём панель с вертикальным менеджером расположения компонентов
        JPanel contents = new JPanel(new VerticalLayout());

        // Добавим кнопки и текстовое поле в панель
        contents.add(new JButton("Products"));
        contents.add(new JButton("Galanterea"));
        // Добавляем текствовое поле длинной 20 символов
        contents.add(new JTextField(20));

        // Размещаем панель в контейнере
        frame.setContentPane(contents);

        // Делаем окно видимым
        frame.setVisible(true);
    }
}
