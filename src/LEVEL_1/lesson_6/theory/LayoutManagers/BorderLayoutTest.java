package LEVEL_1.lesson_6.theory.LayoutManagers;

import javax.swing.*;
import java.awt.*;

/*
BorderLayout разбивает окно на четыре области, а все оставшееся место заполняется компонентом, выполняющим основную функцию приложения.
Чтобы добавить с его помощью компонент, в методе add() необходимо использовать дополнительный параметр, который определяет область контейнера для размещения компонента.
BorderLayout.NORTH (North) — компонент располагается вдоль верхней границы окна и растягивается на всю его ширину. Обычно в этом месте размещается панель инструментов.
BorderLayout.SOUTH (South) — компонент располагается вдоль нижней границы и растягивается на всю ширину окна. Такое положение характерно для строки состояния.
BorderLayout.WEST (West) — компонент располагается вдоль левой границы окна и растягивается на всю его высоту. При этом учитываются размеры северных и южных компонентов, имеющих приоритет.
BorderLayout.EAST (East) — компонент располагается вдоль правой границы окна. В остальном его расположение аналогично западному компоненту.
BorderLayout.CENTER (Center) — компонент помещается в центр окна, занимая максимально возможное пространство.
 */
public class BorderLayoutTest extends JFrame {
    private BorderLayoutTest() {
        super("BorderLayoutTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        // Панель содержимого. Создаём контейнер.
        Container container = getContentPane();
        /*
         * Размещаем в панели компоненты
         * В качестве параметров можно использовать
         * строки и константы класса BorderLayout
         */
        // Начинаем добавлять в контейнер различные элементы
        container.add(new JButton("Север" ), "North"); // можно как и внизу написать BorderLayout.NORTH
        container.add(new JButton("Юг" ), "South");
        container.add(new JLabel ("Запад" ), BorderLayout.WEST);
        container.add(new JLabel ("Восток"), BorderLayout.EAST);
        // При отсутствии 2-го параметра компонент размещается в центре
        container.add(new JButton("Центр"));
        // Открываем окно
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutTest();

    }
}
