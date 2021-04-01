package Lesson1;

public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(3, 6);
        checkSumSign(-1, 1);
        checkSumSign(-2, 1);
        printColor(-7);
        printColor(0);
        printColor(7);
        printColor(100);
        printColor(101);
        compareNumbers(9, 9);
        compareNumbers(9, 5);
        compareNumbers(3, 9);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(int a, int b) {
        int sum = a + b;
        if (sum >= 0) {      // если сумма больше или равна нулю
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println(a + " >= " + b);
        } else {
            System.out.println(a + " < " + b);
        }
    }
}