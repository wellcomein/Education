package LEVEL_2.lesson_6;

/**
 * Основная реализация в родительском классе Messenger
 */
class ServerMessenger extends Messenger {


    ServerMessenger() {
        super(true);
        name = "Server";
        readMessage();
        sendMessage();
    }
    public static void main(String[] args) {
        ServerMessenger serverMessenger = new ServerMessenger();
    }
}
