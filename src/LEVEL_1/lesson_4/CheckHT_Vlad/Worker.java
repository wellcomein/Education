package LEVEL_1.lesson_4.CheckHT_Vlad;

class Worker {
    private String fullname;
    private String position;
    private String email;
    private String Phonenumber;
    private int Salary;
    private int age;

    Worker(String _fulnmae, String _pos, String _email, String _phone, int _salary, int _age){
        this.fullname = _fulnmae;
        this.position = _pos;
        this.email = _email;
        this.Phonenumber = _phone;
        this.Salary = _salary;
        this.age = _age;
    }
    int getAge(){
        return this.age;
    }
    void aboutWorker(){
        System.out.println("----------------------");
        System.out.println("ФИО: "+fullname);
        System.out.println("Должность: "+position);
        System.out.println("Email:" +email);
        System.out.println("Номер телефона: "+Phonenumber);
        System.out.println("Зарплата: "+Salary);
        System.out.println("Возраст: "+age);
    }
}
