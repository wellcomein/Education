package LEVEL_2.lesson_6;

/**
 * Основная реализация в родительском классе Messenger
 */
class ClientMessenger extends Messenger {

    ClientMessenger(String name) {
        super(false);
        this.name = name;
        readMessage();
        sendMessage();
    }

    public static void main(String[] args) {
        ClientMessenger clientMessenger = new ClientMessenger("Vladimir");
    }
}
