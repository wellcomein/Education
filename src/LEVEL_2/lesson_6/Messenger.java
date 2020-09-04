package LEVEL_2.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Родительский класс сервера и клиента
 * Методы класса:
 *   - openDataStream()   - открывает преобразователи входящих и исходящих потоков
 *   - readMessage()      - считывает входящий поток и выводит в консоль
 *   - sendMessage()      - работа с пользователем через консоль, отправка потоков
 *   - makeServer()       - создает локальный сервер, занимает порт, ждёт соединения с клиентом
 *   - connectToServer()  - метод соединения клиента с сервером
 */
class Messenger {
    String name;
    Socket socket;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    String serverAddress = "localhost";
    int serverPort = 54247;
    Scanner scanner = new Scanner(System.in);

    Messenger(boolean isServer) {
        if (isServer) makeServer();
        else connectToServer();
        openDataStream();
    }

    void openDataStream() {
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't open input/output stream");
        }
    }

    //--------------- I/O MESSAGES ------------------------
    void readMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(inputStream.readUTF());
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Can't read message");
                        try {
                            inputStream.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
    void sendMessage() {
        while (true) {
            String message = name + ": " + scanner.nextLine();
            try {
                outputStream.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Can't send the message");
                try {
                    outputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    //--------------- CONNECTING ------------------------
    private void makeServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started on port " + serverSocket.getLocalPort());
            System.out.println("Waiting client connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server not started.");
        }
    }
    void connectToServer() {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server " + serverAddress + ":" + serverPort);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't connect to server: " + serverAddress + ":" + serverPort);
        }
    }
}
