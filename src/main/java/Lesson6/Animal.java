package Lesson6;

public abstract class Animal {
    private static int counterAnimal = 0;
    private final int MAX_RUN_LENGTH = 0;
    private final int MAX_SWIM_LENGTH = 0;
    private final double MAX_JUMP_HEIGTH = 0;
    private String name;

    public Animal(String name) {
        this.name = name;
        counterAnimal++;
    }

    public static int getCountAnimal() {
        return counterAnimal;
    }

    abstract void run(int length);

    abstract void swim(int length);

    abstract void jump(double height);

    public String getName() {
        return name;
    }
}
