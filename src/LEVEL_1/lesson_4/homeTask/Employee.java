package LEVEL_1.lesson_4.homeTask;

// 1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст.
public class Employee {
    public String fullName;
    public String position;
    public String email;
    public String phone;
    public int salary;
    public int age;

    // 2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String name, String position, String mail, String phone, int salary, int age) {
        fullName = name;
        this.position = position;
        email = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void print() {
        System.out.print("Сотрудник: " + this.fullName);
        System.out.print(", должность " + this.position);
        System.out.print(", email " + this.email);
        System.out.print(", телефон " + this.phone);
        System.out.print(", зарплата " + this.salary);
        System.out.println(", возраст " + this.age);

    }

    // 4. Создать массив из 5 сотрудников:
    public static void main(String[] args) {
        Employee[] persArr = new Employee[5];
        persArr[0] = new Employee("Ivanov Ivan", "Engineer", " ivivan@mailbox.com", "892312312", 30000, 30);
        persArr[1] = new Employee("Semenov Semen", "Mechanic", " sesemen@mailbox.com", "892312313", 25000, 28);
        persArr[2] = new Employee("Nikolaev Nikolay", "Locksmith", " ninikolay@mailbox.com", "892312314", 20000, 26);
        persArr[3] = new Employee("Alekseev Aleksey", "Security guard", " alaleksey@mailbox.com", "892312315", 15000, 45);
        persArr[4] = new Employee("Petuhov Peter", "Director", " pepeter@mailbox.com", "892312316", 35000, 41);

        for (Employee employee : persArr) {
            if (employee.age > 40) {
                employee.print();
            }
        }
    }
}
