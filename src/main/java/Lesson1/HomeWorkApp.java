package Lesson1;

import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = in.nextInt();
        System.out.println("Введите второе число");
        int b = in.nextInt();
        int sum = a + b;
        if (sum >= 0) {      // если сумма меньше или равна нулю
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int value = in.nextInt();
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value <= 100){
            System.out.println("Желтый");
        }
        if (value > 100){
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = in.nextInt();
        System.out.println("Введите второе число");
        int b = in.nextInt();
        if (a >= b) {
            System.out.println(a + " >= " + b);
        } else {
            System.out.println(a + " < " + b);
        }
    }
}