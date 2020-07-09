package LEVEL_2.lesson_7;

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
