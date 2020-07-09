package MyNotes.Сеть;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Простейший HTTP сервер.
 * (оригинал статьи: https://habr.com/ru/post/441150/)
 * Если запустить данный код и ввести в окне любого браузера http://localhost:8080,
 * то увидите строку “Привет всем!”, которая была отправлена в ответ веб сервером.
 * При этом сервер напечатает в консоли HTTP запрос, который был ему отправлен браузером.
 *
 * Взаимодействие браузера с веб сервером по протоколу HTTP сводится к пересылке текста в определенном формате.
 * Первуя строка в ответе сервера начинается с GET - это HTTP метод - команда серверу передать в качестве ответа документ, который содержится по указанному адресу.
 * Если написать в окне браузера http://localhost:8080/something, то вместо косой черты будет /something.
 * Через пробел после адреса идет версия протокола. В следующих строках идут HTTP заголовки, которые нужны для передачи серверу различных параметров клиента.
 * В коде вы можете видеть ответ на данный HTTP запрос. Он имеет похожую структуру. Первая строка содержит версию протокола HTTP и код ответа 200, который означает, что запрошенный документ был найден и будет передан в этом ответном запросе.
 * Далее, как и в запросе следуют заголовки (только один, в котором передается кодировка). После заголовков следует пустая строка, которая отделяет заголовок HTTP запроса от его содержания.
 * В данном случае это строка “Привет всем!!!” которую вы увидели в своем браузере.
 */
public class HttpServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started!");

            while (true) {
                // ожидаем подключения
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // для подключившегося клиента открываем потоки
                // чтения и записи
                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                     PrintWriter output = new PrintWriter(socket.getOutputStream())) {

                    // ждем первой строки запроса
                    while (!input.ready()) ;

                    // считываем и печатаем все что было отправлено клиентом
                    System.out.println();
                    while (input.ready()) {
                        System.out.println(input.readLine());
                    }

                    // отправляем ответ
                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println();
                    output.println("<p>Привет всем!</p>");
                    output.flush();

                    // по окончанию выполнения блока try-with-resources потоки,
                    // а вместе с ними и соединение будут закрыты
                    System.out.println("Client disconnected!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
