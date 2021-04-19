package Lesson6;

public class Dog extends Animal {
    private final int MAX_RUN_LENGTH = 500;
    private final int MAX_SWIM_LENGTH = 10;
    private final double MAX_JUMP_HEIGTH = 0.5;
    private static int countDog = 0;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    public static int getCountDog() {
        return countDog;
    }

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH))
            System.out.println("Собака " + getName() + " пробежала " + length + " м");
        else System.out.println("Собака " + getName() + " может пробежать максимум " + MAX_RUN_LENGTH + " м");
    }

    @Override
    void swim(int length) {
        if ((length >= 0) && (length <= MAX_SWIM_LENGTH))
            System.out.println("Собака " + getName() + " проплыла " + length + " м");
        else System.out.println("Собака " + getName() + " может проплыть максимум " + MAX_SWIM_LENGTH + " м");
    }

    @Override
    void jump(double height) {
        if ((height >= 0) && (height <= MAX_JUMP_HEIGTH))
            System.out.println("Собака " + getName() + " прыгнула на " + height + " м");
        else System.out.println("Собака " + getName() + " может прыгнуть максимум " + MAX_JUMP_HEIGTH + " м");
    }
}
