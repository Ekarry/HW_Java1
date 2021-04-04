package lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        arrayZeroOne();
        createArray();
        arrayChangeTwo();
        createArray2(7);
        createArrayLenValue(5, 9);
        findMiniMaxArray(16, -3, 7);
        System.out.println(checkBalance(new int[]{1, 2, 1, 1, 1})); // true
        System.out.println(checkBalance(new int[]{2, 3, 1, 2, 11})); // false
        System.out.println(checkBalance(new int[]{5, 5, 10})); //true
        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, -3);
        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0);
        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);

    }

    public static void arrayZeroOne() {
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Начальный массив: " + (Arrays.toString(array)));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        System.out.println("Массив после замены:  " + (Arrays.toString(array)));
    }

    public static void createArray() {
        int[] array = new int[100];
        System.out.println("\nБыл создан массив: " + (Arrays.toString(array)));
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void arrayChangeTwo() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\nНачальный массив: " + (Arrays.toString(array)));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] = array[i] * 2;
        }
        System.out.println("Массив после замены:  " + (Arrays.toString(array)));
    }

    static void createArray2(int length) { // length of array
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((i + j) % 2 == 0) {
                    array[i][j] = 1;
                } else array[i][j] = 0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void createArrayLenValue(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        System.out.println("\nБыл создан массив: " + (Arrays.toString(array)));
    }

    static void findMiniMaxArray(int length, int min, int max) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (min + Math.random() * max);
        }
        System.out.println("\nБыл создан массив: " + (Arrays.toString(array)));
        min = 0;
        max = 0;
        for (int i = 0; i < array.length; i++) {
            min = (min < array[i]) ? min : array[i];
            max = (max > array[i]) ? max : array[i];
        }
        System.out.println("\nМинимальное значение в массиве: " + min + "\nМаксимальное значение в массиве: " + max);
    }

    static boolean checkBalance(int[] array) {
        int leftSum, rightSum;
        for (int i = 0; i < array.length + 1; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }
            for (int j = i; j < array.length; j++) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    static void shiftArray(int[] array, int n) {
        System.out.println("\nНачальный массив: " + (Arrays.toString(array)));
        if (n == 0) {
            System.out.print("Сдвиг не может быть равен нулю (n = " + n + ")" + "\nПоэтому массив не будет изменен: ");
        } else if (n > 0) {
            System.out.print("Сдвиг будет вправо, т.к. n = " + n + "\nМассив после изменения: ");
            for (int i = 0; i < n; i++) {
                int tmp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = tmp;
            }
        } else {
            System.out.println("Сдвиг будет влево, так как n = " + n + "\nМассив после изменения: ");
            for (int i = 0; i < n * (-1); i++) {
                int tmp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = tmp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
