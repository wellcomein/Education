package LEVEL_2.lesson_1;

interface Abilities {
    String run();
    String jump();

    /**
     * Бег и проверка смог ли пробежать
     * @param discipline - объект родительсткого класса для беговой дорожки и стены
     * @return - текстровое представление результата бега
     */
    String run(Discipline discipline);

    /**
     * Прыжок и проверка смог ли перепрыгнуть
     * @param discipline - объект родительсткого класса для беговой дорожки и стены
     * @return - текстровое представление результата пражка
     */
    String jump(Discipline discipline);

    /**
     * Проверяет соответствует ли бег беговой дорожке и прыжок стене.
     * При соответствии запускает соответствуйющий метод run или jump
     * @param discipline - объект родительсткого класса для беговой дорожки и стены
     */
    void move(Discipline discipline);

    boolean isPassed();
}
