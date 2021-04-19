package lesson7;

public class Main {
    public static void main(String[] args) {
        System.out.println("Список котов:");
        Cat[] x = {new Cat("Матроскин", 207), new Cat("Полосатый", 175), new Cat("Рыжий", 150)};
        Plate plate = new Plate(100);
        for (Cat c : x) {
            System.out.println(c);
        }
        System.out.println(plate);
        System.out.println("***********************************************");


        plate.increaseFood(250);
        System.out.println("Добавим ещё 250 гр.");
        System.out.println(plate);
        System.out.println("***********************************************");
        System.out.println("Кошары начинают есть:");
        for (Cat c : x) {
            c.eat(plate);
            System.out.println(c);
            System.out.println(plate);
        }
    }
}
