package MyNotes.Сеть;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * НАПИСАНИЕ ЭХО СЕРВЕРА
 * Создается объект класса ServerSocket, представляющий собой сервер, который прослушивает порт 8189
 * Блок try-with-resources предназначен для гарантированного закрытия всех сетевых соединений и освобождения ресурсов.
 * server.accept() переводит основной поток в режим ожидания. Пока никто не подключится, следующая строка кода выполнена не будет.
 * Как только клиент подключился, информация о соединении с ним запишется в объект типа Socket.
 * DataInputStream - обработчик входящего потока для обмена сообщениями с клиентом.
 * DataOutputStream - обработчик исходящего потока для обмена сообщениями с клиентом.
 * Сервер считывает сообщение, переданное клиентом, добавляет к нему фразу «Эхо: » и отсылает обратно.
 * Если клиент прислал сообщение «end», то общение с ним прекращается, и сокет закрывается.
 */
class EchoServer {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")) {
                    break;
                }
                out.writeUTF("Эхо: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
