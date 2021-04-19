package Lesson6;

public class Cat extends Animal {
    private final int MAX_RUN_LENGTH = 200;
    private final double MAX_JUMP_HEIGTH = 2;
    private static int countCat = 0;

    public Cat(String name) {
        super(name);
        countCat++;
    }

    public static int getCountCat() {
        return countCat;
    }

    @Override
    void run(int length) {
        if ((length >= 0) && (length <= MAX_RUN_LENGTH))
            System.out.println("Кошка " + getName() + " пробежала " + length + " м");
        else System.out.println("Кошка " + getName() + " может пробежать максимум " + MAX_RUN_LENGTH + " м");
    }

    @Override
    void swim(int length) {
        System.out.println("Кошка " + getName() + " не умеет плавать");
    }

    @Override
    void jump(double height) {
        if ((height >= 0) && (height <= MAX_JUMP_HEIGTH))
            System.out.println("Кошка " + getName() + " прыгнула на " + height + " м");
        else System.out.println("Кошка " + getName() + " может прыгнуть максимум " + MAX_JUMP_HEIGTH + " м");
    }
}
