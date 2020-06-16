package LEVEL_1.lesson_5;

import java.nio.charset.StandardCharsets;


// После оператора package — но до начала описания классов в коде — может присутствовать список операторов import.
// import package1[.package2].(имякласса|*);
// В конце пишется либо имя конкретного подключаемого класса, либо звездочка, которая обозначает возможность подключения любого класса из указанного пакета.


// Экземпляр строки добавляется в Java множеством способов.
public class theory {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = new String("Home");
        String s3 = new String(new char[]{'A', 'B', 'C'});
        String s4 = new String(s3);
        String s5 = new String(new byte[]{65, 66, 67});
        String s6 = new String(new byte[]{0, 65, 0, 66}, StandardCharsets.UTF_16);
        System.out.printf("s1 = %s, s2 = %s, s3 = %s, s4 = %s, s5 = %s, s6 = %s", s1, s2, s3, s4, s5, s6);
        // Результат:
        // s1 = Java, s2 = Home, s3 = ABC, s4 = ABC, s5 = ABC, s6 = AB


        // Строки можно наращивать или конкатенировать. Это, по сути, операция сложения строк.
        String a1 = "Hello ";
        String a2 = "World";
        String a3 = a1 + a2;
        System.out.println(a3);
        String b1 = "Число 10: ";
        int b2 = 10;
        String b3 = b1 + b2;
        System.out.println(b3);
        String c1 = "Home";
        String c2 = "[" + c1 + "] = " + 1;
        System.out.println(c2);
        // Результат:
        // Hello World
        // Число 10: 10
        // [Home] = 1

    }
}