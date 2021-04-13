package lesson5;

public class Employee {
    String firstname, name, middlename, position, email;
    int salary, age;

    Employee(String firstname,
             String name,
             String middlename,
             String position,
             String email,
             int salary,
             int age) {
        this.firstname = firstname;
        this.name = name;
        this.middlename = middlename;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    void getFullInfo() {
        System.out.println("Ф.И.О: " + firstname + " " + name + " " + middlename
                + "\n возраст: " + age
                + "\n должность: " + position + " | заработная плата: " + salary
                + "\n e-mail: " + email);
    }

    int getAge() {
        return age;
    }
}
