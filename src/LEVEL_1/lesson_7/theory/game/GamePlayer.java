package LEVEL_1.lesson_7.theory.game;

class GamePlayer {
    private char playerSign;                // символ которым играет игрок
    private boolean realPlayer = true;      // признак того, что играет реальные игрок или компьютер

    public GamePlayer(boolean isRealPlayer, char playerSign) {
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }

    // Чтобы иметь доступ к приватным полям из вне создаём геттеры
    public boolean isRealPlayer() {return realPlayer;}      // создаём геттер для верхней переменной realPlayer.
    public char getPlayerSign() {return playerSign;}        // создаём геттер для верхней переменной playerSign
}
