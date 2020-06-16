package LEVEL_1.lesson_6.theory.LayoutManagers;

import java.awt.*;

// Менеджер вертикального расположения компонентов
class VerticalLayout implements LayoutManager {
    private Dimension size = new Dimension();

    // не используется
    // служит для добавления компонентов
    @Override
    public void addLayoutComponent(String name, Component comp) {}
    // не используется
    // служит для удажения компонентов из списка
    @Override
    public void removeLayoutComponent(Component comp) {}

    // Метод определения предпочтительного размера контейнера
    @Override
    public Dimension preferredLayoutSize(Container c) {
        return calculateBestSize(c);
    }

    // Метод определения минимального размера контейнера
    @Override
    public Dimension minimumLayoutSize(Container c) {
        return calculateBestSize(c);
    }

    // Метод расположения компонентов в контейнере
    @Override
    public void layoutContainer(Container container) {
    // расположение элементов по вертикали на растоянии друг от друга в 5 пикселей

        // Список компонентов
        Component list[] = container.getComponents();
        int currentY = 5;
        for (Component component : list) {
            // Определение предпочтительного размера компонента
            Dimension pref = component.getPreferredSize();
            // Размещение компонента на экране
            component.setBounds(5, currentY, pref.width, pref.height);
            // Учитываем промежуток в 5 пикселов
            currentY += 5;
            // Смещаем вертикальную позицию компонента
            currentY += pref.height;
        }
    }
    
    // Написанный нами метод для вычисления наилучшего размера
    // Метод вычисления оптимального размера контейнера
    private Dimension calculateBestSize(Container c) {

        // Вычисление длины контейнера
        // Среди всех контейнеров находим контейнер с самой большой длинной и высотой и делаем эти показатели основными.
        // А затем прибавляем еще 5 пикселей чтобы хорошо смотрелось
        Component[] list = c.getComponents();
        int maxWidth = 0;
        for (int i = 0; i < list.length; i++) {
            int width = list[i].getWidth();
            // Поиск компонента с максимальной длиной
            if ( width > maxWidth )
                maxWidth = width;
        }

        // Размер контейнера в длину с учетом левого отступа
        size.width = maxWidth + 5;

        // Вычисление высоты контейнера
        int height = 0;
        for (int i = 0; i < list.length; i++) {
            height += 5;
            height += list[i].getHeight();
        }

        size.height = height;
        return size;
    }
}
