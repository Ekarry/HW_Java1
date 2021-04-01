package Lesson2;

public class HomeWorkApp2 {

    public static void main(String[] args) {
        checkSum(7, 5);
        checkSum(3, -2);
        checkSum(10, 11);
        printChekInt(10);
        printChekInt(-1);
        printChekInt(0);
        checkInt(-1);
        checkInt(0);
        checkInt(2);
        printStringNTimes("Число равно ", 6);
        checkYear(200);
        checkYear(400);
        checkYear(600);
        checkYear(2020);
        checkYear(2022);
    }

    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum > 9 & sum < 21) {
            return true;
        }
        return false;
    }

    public static void printChekInt(int n) {
        if (n >= 0) {
            System.out.println("Число " + n + " положительное");
        } else {
            System.out.println("Число " + n + " отрицательное");
        }
    }

    public static boolean checkInt(int i) {
        if (i == 0) {
            System.out.println("Число равно нулю");
        } else if (i < 0) {
            return true;
        }
        return false;
    }

    public static void printStringNTimes(String text, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(text + (i + 1));
        }
    }

    public static boolean checkYear(int year) {
        if (year % 4 == 0 & year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

}
