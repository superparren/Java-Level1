package Sabirov.LLesson5;

public class Employee {
    private String Fullname;
    private String position;
    private String email;
    private int phone;
    private int salary;
    private int age;

    public Employee(String Fullname, String position, String email, int phone, int salary, int age) {
        this.Fullname = Fullname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return String.format("Имя: %s \tДолжность: %s \nEmail: %s \t Номер телефона: %s \n Зарплата: %d \t Возраст: %d \n",
                Fullname, position, email, phone, salary, age);
    }

    void printinfo() {
        System.out.print(this);
    }


    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Allex Braun", "manager", "alexbran@firma.com", 745685554, 300, 35);
        employeesArray[1] = new Employee("George Bush", "artist", "georgebush@firma.com", 75876251, 100, 55);
        employeesArray[2] = new Employee("Nick Collin", "BD", "nickcollin@firma.com", 769525489, 400, 44);
        employeesArray[3] = new Employee("Paul Newman", "superviser", "paulnewman@firma.com", 365964785, 350, 41);
        employeesArray[4] = new Employee("John Deer", "adviser", "johndeer@firma.com", 732266654, 500, 28);

        for (int i = 0; i < 5; i++)
            if (employeesArray[i].age > 40) employeesArray[i].printinfo();
    }
}


