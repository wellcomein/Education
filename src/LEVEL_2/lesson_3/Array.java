package LEVEL_2.lesson_3;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Чтобы раскрыть тему урока решение будет реализовано с помощью методов LinkedHashMap,
 * так как оптимально подходит для создания пары слово-количество повторений этого слова,
 * а так же HashMap автоматически удаляет (перезапичывает) повторяющиеся ключи.
 */
class Array {
    private static String[] array;

    private static LinkedHashMap<String, Integer> count (String[] array) {
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {             // Пробежались по массиву
            if (!hashMap.containsKey(array[i])) {            // Если HashMap не содержет слова из массива,
                hashMap.put(array[i], 1);                    // то добавляем это слово в HashMap и присваиваем, что всречается 1 раз
            }
            else {                                           // В потивном случае
                int value = hashMap.get(array[i]);           // берейм предыдущее значение в необходимой ячейке HashMap
                hashMap.put(array[i], value + 1);            // и итерируем его на единицу.
            }
        }
        return hashMap;
    }

    /**
     * Второе решение этой задачи от преподавателя
     */
    private static Map<String, Integer> distinctWord(String[] array) {
        Map<String, Integer> statistic = new HashMap<>();
        for (String word:array) {
            statistic.put(word, statistic.getOrDefault(word, 0)+1);
        }
        return statistic;
    }

    public static void main (String[] args) {
        array = new String[]{
                "Создать", "массив", "с", "набором", "слов", "(", "10-20 ", "слов", "должны", "встречаться",
                "повторяющиеся", "). ", "Найти", "и", "вывести", "список", "уникальных", "слов", "из",
                "которых", "состоит", "массив", "(", "дубликаты", "не", "считаем", ").",
                "Посчитать", "сколько", "раз", "встречается", "каждое", "слово"
        };

        System.out.println(count(array));
        System.out.println(distinctWord(array));
    }
}
