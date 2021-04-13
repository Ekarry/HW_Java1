package lesson5;

public class homeWorkApp5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов", "Иван", "Иванович",
                "Top manager", "ivanovii@mail.me", 150000, 45);
        employees[1] = new Employee("Петров", "Петр", "Петрович", "manager middle",
                "petrovpp@mail.me", 50000, 30);
        employees[2] = new Employee("Сидоров", "Вячеслав", "Станиславович",
                "manager junior", "sidorovvs@mail.me", 35000, 25);
        employees[3] = new Employee("Васин", "Василий", "Васильевич",
                "manager", "vasinVV@mail.me", 650000, 41);
        employees[4] = new Employee("Семенов", "Семен", "Семенович",
                "manager", "semenovss@mail.me", 300000, 23);

        for (Employee e : employees) if (e.getAge() > 40) e.getFullInfo();
    }
}
