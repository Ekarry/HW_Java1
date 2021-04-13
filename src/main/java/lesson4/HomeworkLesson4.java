package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeworkLesson4 {
    private static final char DEFAULT = '_';
    private static final char X = 'X';
    private static final char O = 'O';
    private static final char cpu2 = 'W', cpu3 = 'Z';
    private static final int SIZE = 3;
    private static final char[][] MAP = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public static void main(String[] args) {
        HomeworkLesson4 g = new HomeworkLesson4();
        g.initMap();
        g.printMap();

        while (true) {
            //player turn
            g.playerTurn();
            g.printMap();
            if (g.checkWin(g.X)) {
                System.out.println("Поздравляем! Вы победитель");
                break;
            }
            if (g.isMapFull()) {
                System.out.println("Игра окончена. НИЧЬЯ");
                break;
            }

            //AI-1 turn
            g.aiTurn(g.O);
            g.printMap();
            if (g.checkWin(g.O)) {
                System.out.println("Игра окончена. Выйграл компьютер");
                break;
            }
            if (g.isMapFull()) {
                System.out.println("Игра окончена. НИЧЬЯ");
                break;
            }

//Too much players
//            //AI-2 turn
//            g.aiTurn(g.cpu2);
//            g.printMap();
//            if (g.checkWin(g.cpu2)) { System.out.println("Игра окончена. Выйграл компьютер_1"); break; }
//            if (g.isMapFull()) { System.out.println("Игра окончена. НИЧЬЯ"); break; }
//
//
//            //AI-3 turn
//            g.aiTurn(g.cpu3);
//            g.printMap();
//            if (g.checkWin(g.cpu3)) { System.out.println("Игра окончена. Выйграл компьютер_2"); break; }
//            if (g.isMapFull()) { System.out.println("Игра окончена. НИЧЬЯ"); break; }
        }
    }

    static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }

    void playerTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход. Введите координаты ячейки");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            //System.out.println("Your enter coordinates: x = " + (x + 1) + ", y = " + (y + 1));
        } while (!isCellValid(x, y));
        MAP[y][x] = X;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) return false;
        if (MAP[y][x] == DEFAULT) return true;
        return false;
    }

    boolean checkWin(char c) {
        int countV;
        int countH;
        int countDiagonalA = 0;
        int countDiagonalB = 0;
        for (int i = 0; i <= SIZE - 1; i++) {
            countH = 0;
            countV = 0;
            for (int j = 0; j <= SIZE - 1; j++) {
                //tested horizontal check
                if (MAP[i][j] == c) {
                    countH++;
                    if (countH == SIZE) return true;
                }

                //tested vertical check
                if (MAP[j][i] == c) {
                    countV++;
                    if (countV == SIZE) return true;
                }
            }
            // tested diagonal A "\" check
            if (MAP[i][i] == c) {
                countDiagonalA++;
                if (countDiagonalA == SIZE) return true;
            } else countDiagonalA = 0;
            // tested diagonalB "/" check
            if (MAP[i][SIZE - 1 - i] == c) {
                countDiagonalB++;
                if (countDiagonalB == SIZE) return true;
            } else countDiagonalB = 0;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DEFAULT) return false;
            }
        }
        return true;
    }

    void aiTurn(char c) {
        int x = 0, y = 0, countH = 0, countHNull = 0, countV = 0, countVNull = 0, countDiagonalA = 0, countDiagonalB = 0, countDANull = 0, countDBNull = 0;

        System.out.println("Компьютер сделал ход [" + c + "]:");

        // 1. Atack player
        for (int i = 0; i < SIZE; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < SIZE; j++) {
                //good vertical move
                if (MAP[j][i] == c) countV++;
                else if (MAP[j][i] == DEFAULT) countVNull++;
                if ((countV == SIZE - 1) && (countVNull == 1)) {
                    //System.out.println("Компьютер всегда побеждает! vert line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < SIZE; k++) {
                        if (MAP[k][i] == DEFAULT) {
                            MAP[k][i] = c;
                            return;
                        }
                    }
                }
                //good Horizontal move
                if (MAP[i][j] == c) countH++;
                else if (MAP[i][j] == DEFAULT) countHNull++;
                if ((countH == SIZE - 1) && (countHNull == 1)) {
                    //System.out.println("Компьютер всегда побеждает! horiz line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < SIZE; k++) {
                        if (MAP[i][k] == DEFAULT) {
                            MAP[i][k] = c;
                            return;
                        }
                    }
                }

            }

            // good diagonal A "\" move
            if (MAP[i][i] == c) countDiagonalA++;
            else if (MAP[i][i] == DEFAULT) countDANull++;
            if ((countDiagonalA == SIZE - 1) && (countDANull == 1)) {
                //System.out.println("Компьютер всегда побеждает! diagA line \\");
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[j][j] == DEFAULT) {
                        MAP[j][j] = c;
                        return;
                    }
                }
            }

            // good diagonal B "/" move
            if (MAP[i][SIZE - 1 - i] == c) countDiagonalB++;
            else if (MAP[i][SIZE - 1 - i] == DEFAULT) countDBNull++;
            if ((countDiagonalB == SIZE - 1) && (countDBNull == 1)) {
                //System.out.println("Компьютер всегда побеждает! diagB line /");
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[j][SIZE - 1 - j] == DEFAULT) {
                        MAP[j][SIZE - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        countH = 0;
        countHNull = 0;
        countV = 0;
        countVNull = 0;
        countDiagonalA = 0;
        countDiagonalB = 0;
        countDANull = 0;
        countDBNull = 0;

        // 2. Blocking player
        for (int i = 0; i < SIZE; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < SIZE; j++) {
                //good vertical move
                if (MAP[j][i] == x) countV++;
                else if (MAP[j][i] == DEFAULT) countVNull++;
                if ((countV == SIZE - 1) && (countVNull == 1)) {
                    //System.out.println("Предупреждение для компьютера! vert line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < SIZE; k++) {
                        if (MAP[k][i] == DEFAULT) {
                            MAP[k][i] = c;
                            return;
                        }
                    }
                }
                //good Horizontal move
                if (MAP[i][j] == x) countH++;
                else if (MAP[i][j] == DEFAULT) countHNull++;
                if ((countH == SIZE - 1) && (countHNull == 1)) {
                    //System.out.println("Предупреждение для компьютера! horiz line = " + (i + 1)); // i - horiz line
                    for (int k = 0; k < SIZE; k++) {
                        if (MAP[i][k] == DEFAULT) {
                            MAP[i][k] = c;
                            return;
                        }
                    }
                }

            }

            // good diagonal A "\" move
            if (MAP[i][i] == x) countDiagonalA++;
            else if (MAP[i][i] == DEFAULT) countDANull++;
            if ((countDiagonalA == SIZE - 1) && (countDANull == 1)) {
                //System.out.println("Предупреждение для компьютера! diagA line \\");
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[j][j] == DEFAULT) {
                        MAP[j][j] = c;
                        return;
                    }
                }
            }

            // good diagonal B "/" move
            if (MAP[i][SIZE - 1 - i] == x) countDiagonalB++;
            else if (MAP[i][SIZE - 1 - i] == DEFAULT) countDBNull++;
            if ((countDiagonalB == SIZE - 1) && (countDBNull == 1)) {
                //System.out.println("Предупреждение для компьютера! diagB line /");
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[j][SIZE - 1 - j] == DEFAULT) {
                        MAP[j][SIZE - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        // 3. Taking center of map
        if (!(SIZE % 2 == 0)) {
            int center = (((SIZE + 1) / 2) - 1);
            if (MAP[center][center] == DEFAULT) {
                MAP[center][center] = c;
                return;
            }
        }

        // 4. Taking diagonal points of map
        if (MAP[0][0] == DEFAULT) {
            MAP[0][0] = c;
            return;
        }
        if (MAP[0][MAP.length - 1] == DEFAULT) {
            MAP[0][MAP.length - 1] = c;
            return;
        }
        if (MAP[MAP.length - 1][0] == DEFAULT) {
            MAP[MAP.length - 1][0] = c;
            return;
        }
        if (MAP[MAP.length - 1][MAP.length - 1] == DEFAULT) {
            MAP[MAP.length - 1][MAP.length - 1] = c;
            return;
        }

        // 5. random move
        //System.out.println("AI random");
        do {
            x = r.nextInt(SIZE);
            y = r.nextInt(SIZE);
        } while (!isCellValid(x, y));
        MAP[y][x] = c;
        System.out.println("AI X: " + (x + 1) + " Y: " + (y + 1));
    }
}