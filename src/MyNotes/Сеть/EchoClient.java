package MyNotes.Сеть;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * НАПИСАНИЕ КЛИЕНТСКОЙ ЧАСТИ
 * prepareGUI() - занимается подготовкой интерфейса Swing к работе.
 * openConnection() - подключение к серверу
 * closeConnection() - закрытие подключения
 * sendMessage() - метод для отправки сообщения в сторону сервера
 */
class EchoClient extends JFrame {
    /**
     * SERVER_ADDR - задаёт адрес эхо-сервера
     * SERVER_PORT — номер порта
     * socket - для открытия соединения с сервером и обмена сообщениями.
     * DataInputStream - обработчик входящего потока для обмена сообщениями с клиентом.
     * DataOutputStream - обработчик исходящего потока для обмена сообщениями с клиентом.
     */
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private JTextField msgInputField;
    private JTextArea chatArea;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public EchoClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareGUI();
    }
    /**
     * 1. открываем сокет.
     * 2. с помощью socket.getInputStream() запрашиваем у сокета доступ к исходящему(в сторону сервера) потоку.
     * 3. с помощью getOutputStream() запрашиваем у сокета доступ к входящему(направленному к нашему клиенту) потоку.
     * 4. запускаем отдельный поток, чтобы слушать что пришлет сервер.
     * 5. в этом потоке запускается цикл while() и начинает слушать входящие сообщения.
     * 6. Как придет сообщение от сервера, записываем его в строку strFromServer
     * 7. эту строку выводим в основное текстовое поле чата charArea.
     * Для закрытия же используется довольно простой метод closeConnection().
     * @throws IOException
     */
    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        chatArea.append(strFromServer);
                        chatArea.append("\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Клиент берет содержимое текстового поля для отправки
     * с помощью метода writeUTF() отправляет его серверу,
     * после чего очищает текстовое поле и переводит на него фокус.
     * Если не удалось отправить сообщение, то будет показано всплывающее окно с ошибкой.
     */
    public void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                out.writeUTF(msgInputField.getText());
                msgInputField.setText("");
                msgInputField.grabFocus();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
            }
        }
    }

    public void prepareGUI() {
        // Параметры окна
        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Текстовое поле для вывода сообщений
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        msgInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Настраиваем действие на закрытие окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("/end");
                    closeConnection();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EchoClient();
            }
        });
    }
}
