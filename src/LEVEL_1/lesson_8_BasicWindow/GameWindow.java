package LEVEL_1.lesson_8_BasicWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame{

    private static GameWindow game_window;                      // Объявили переменную, с которой будем работать
    private static long last_frame_time;                        // Переменная хранящая время

    private static Image background;                            // Стандартный класс Image создан для работы с изображениями. Переменная для заднего фона
    private static Image game_over;                             // Переменная отрисовки надписи Гейм овер
    private static Image drop;                                  // Переменная отрисовки капли

    private static float drop_left = 200;                       // Координаты левого верхнего угла капли по оси х
    private static float drop_top = -100;                       // Координаты левого верхнего угда капли по оси у
    private static float drop_speed = 200;                      // Устанавиливаем скорость капли
    private static int score;                                   // Переменная подсчёта очков


    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));      // прикрепление к переменной картинки
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));        // прикрепление к переменной картинки
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));                  // прикрепление к переменной картинки

        game_window = new GameWindow();                         // Создан объект класса GameWindow и поместили в переменную game_window

        // Настройки созданного окна game_window
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(906, 478);
        game_window.setResizable(false);

        last_frame_time = System.nanoTime();                    // Присвоение переменной начального времени

        GameField game_field = new GameField();                 // Создаём панель для окна
        game_field.addMouseListener(new MouseAdapter() {        // Слушает нажатие мышки
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX();                               // Получение координаты мишы по оси х
                int y = e.getY();                               // Получение координаты мыши по оси у

                float drop_right = drop_left + drop.getWidth(null);         // узнаём правый край капли
                float drop_bottom = drop_top + drop.getHeight(null);        // узнаём нижний край капли
                boolean isDrop = x>=drop_left && x<=drop_right && y>=drop_top && y<=drop_bottom;        //Соврадают ли координаты капли с координатами мыши
                if(isDrop) {
                    drop_top = -100;                            // откидываем каплю за пределы поля по оси у
                    drop_left = (int) (Math.random() * (game_field.getWidth() - drop.getWidth(null)));      // откидываем куплю в случайное место за пределы поля
                    drop_speed = drop_speed + 20;                // Увеличиваем скорость капли
                    score++;
                    game_window.setTitle("Score: " + score);
                }
            }
        });

        game_window.add(game_field);                            // Добавляем панель в окно
        game_window.setVisible(true);
    }

    // Стандартный метод для рисования
    private static void onRepaint(Graphics g){
        long current_time = System.nanoTime();                                      // Записывает текущее время
        float delta_time = (current_time - last_frame_time) * 0.000000001f;         // разница во времени переведённая в секунды
        last_frame_time = current_time;
        drop_top = drop_top + drop_speed * delta_time;                              // Обновляем координаты капли

        g.drawImage(background, 0, 0, null);                        // Отрисовываем задний фон в точке 0,0
        g.drawImage(drop, (int)drop_left, (int)drop_top, null);            // Отрисовываем каплю
        if (drop_top > game_window.getHeight()) g.drawImage(game_over, 280, 120, null); // Отрисовываем надпись если верхняя точка капли больше высоты окна

        g.fillOval(10, 10, 200,100);        // Нарисовать овал
        g.drawLine(10,10,10,100);               // Нарисовать линию
    }

    private static class GameField extends JPanel{              // Создание панелей в окне, на которых можно рисовать

        @Override
        protected void paintComponent(Graphics g){              // Переопределяем метод в классе JPanel
            super.paintComponent(g);
            onRepaint(g);
            repaint();                                          // метод, постоянно перерисовывающий панель
        }
    }
}