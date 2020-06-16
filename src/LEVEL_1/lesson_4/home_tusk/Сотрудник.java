package LEVEL_1.lesson_4.home_tusk;

// 1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст.
public class Сотрудник {
    public String ФИО;
    public String должность;
    public String email;
    public String телефон;
    public int зарплата;
    public int возраст;

    // 2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Сотрудник(String name, String position, String mail, String phone, int salary, int age) {
        ФИО = name;
        должность = position;
        email = mail;
        телефон = phone;
        зарплата = salary;
        возраст = age;
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void print() {
        System.out.print("Сотрудник: " + this.ФИО);
        System.out.print(", должность " + this.должность);
        System.out.print(", email " + this.email);
        System.out.print(", телефон " + this.телефон);
        System.out.print(", зарплата " + this.зарплата);
        System.out.println(", возраст " + this.возраст);

    }

    // 4. Создать массив из 5 сотрудников:
    public static void main(String[] args) {
        Сотрудник[] persArr = new Сотрудник[5];
        persArr[0] = new Сотрудник("Ivanov Ivan", "Engineer", " ivivan@mailbox.com", "892312312", 30000, 30);
        persArr[1] = new Сотрудник("Semenov Semen", "Mechanic", " sesemen@mailbox.com", "892312313", 25000, 28);
        persArr[2] = new Сотрудник("Nikolaev Nikolay", "Locksmith", " ninikolay@mailbox.com", "892312314", 20000, 26);
        persArr[3] = new Сотрудник("Alekseev Aleksey", "Security guard", " alaleksey@mailbox.com", "892312315", 15000, 45);
        persArr[4] = new Сотрудник("Petuhov Peter", "Director", " pepeter@mailbox.com", "892312316", 35000, 41);

        for (int i = 0; i < persArr.length; i++) {
            if (persArr[i].возраст > 40) {
                persArr[i].print();
            }

        }
    }
}
