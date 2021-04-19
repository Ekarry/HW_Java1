package Lesson6;

public class homeWorkApp6 {
    public static void main(String[] args) {
        Cat cat = new Cat("Котюля");
        cat.run(201);
        cat.swim(1);
        cat.jump(1.9);


        Dog dog = new Dog("Собачюля");
        dog.run(500);
        dog.swim(10);
        dog.jump(0.4);

        Dog dog1 = new Dog("Собакевич");
        dog1.run(501);
        dog1.swim(50);
        dog1.jump(2);

        System.out.println("Животных в итоге " + Animal.getCountAnimal() + " шт.");
        System.out.println("Кошачьих в итоге " + Cat.getCountCat() + " шт.");
        System.out.println("Собачек в итоге " + Dog.getCountDog() + " шт.");
    }
}
