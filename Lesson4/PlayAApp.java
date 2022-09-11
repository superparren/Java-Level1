package Sabirov.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class PlayAApp {
    private static int size;
    private static int winSize;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';

    private  static char[][] map = new char[size][size];

    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();
    public static final String MAP_FIRST_SYMBOL = "@";
    public static final String SPACE_MAP_SYMMBOL = " ";

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        do {
            System.out.println("\n\n START GAAME");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
    }

    private static void init() {
        size = getSizefromUser();
        winSize = setWinSize();
        initMap();
    }

    private static int setWinSize() {
        if (size >= 3 && size <= 6){
            return 3;
        } else if (size > 6 && size <= 10){
            return 4;
        }
        return 5;
    }

    private static int getSizefromUser() {
        System.out.print("CHOOSE GAME SIZE");
        return in.nextInt();
    }

    private static boolean isContinueGame() {
        System.out.println("FOR CONTINE PRESS-Y, FOR EXIT PRESS N");
        return switch (in.next()){
            case "y", "Y", "н", "Н" -> true;
            default -> false;
        };
    }

    private static void playGame() {
        while (true){
            humanStep();
            printMap();
            if (checkEnd(DOT_HUMAN)){
                break;
            }

            aiStep();
            printMap();
            if (checkEnd(DOT_AI)){
                break;
            }
        }
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin (symbol)){
            if (symbol == DOT_HUMAN){
                System.out.println("You are the BEST");
            } else {
                System.out.println("LOOSER");
            }
            return true;
        }
        if (checkDraw()){
            System.out.println("Nobody Win");
            return true;
        }
        return (false);
    }

    private static boolean checkDraw() {
        for (char[] chars : map) {
            for (char symbol : chars){
                if (symbol == DOT_EMPTY){
                    return false;
                }
            }
        } return true;
    }

    private static boolean checkWin(char symbol) {
        if(map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol){
            return true;
        }
        if(map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol){
            return true;
        }
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol){
            return true;
        }
        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol){
            return true;
        }
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol){
            return true;
        }
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol){
            return true;
        }
        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol){
            return true;
        }
        if (map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol){
            return true;
        }
        return false;
    }

    private static void aiStep() {
        System.out.println("\n Копьютер ходит");
        int rownmber;
        int columnnumber;

        do {
            rownmber = random.nextInt(size);

            columnnumber = random.nextInt(size);

            if (isCellValid(rownmber, columnnumber)){
                break;
            }
        }
        while (!isCellValid(rownmber, columnnumber));

            map[rownmber][columnnumber] = DOT_AI;
    }

    private static void humanStep() {
        System.out.println("\n Ваш ход");
        int rownmber;
        int columnnumber;

        while (true) {
            System.out.print("Введите номер строки");
            rownmber = getValidLinenumFromSc();

            System.out.print("Введите номер столбца");
            columnnumber = getValidLinenumFromSc();

            if (isCellValid(rownmber, columnnumber)){
                break;
            }
            System.out.printf("Поле занято ", rownmber, columnnumber);
        }

        map[rownmber][columnnumber] = DOT_HUMAN;
    }

    private static int getValidLinenumFromSc() {
        return getValidnumFromSc(1, size) - 1;
    }

    private static int getValidnumFromSc(int min, int max) {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isnumberValid(n, min, max)) {
                    return n;
                }
                System.out.printf("ERROR");
            } else {
                System.out.printf("ERROR", in.next());
            }
        }
    }

    private static boolean isnumberValid(int n, int min, int max) {
        return n >= min && n <= max;
    }

    private static boolean isCellValid(int rownmber, int columnnumber) {
        return map[rownmber][columnnumber] == DOT_EMPTY;
    }

    private static void initMap() {
        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeader();
        printBody();
    }

    private static void printBody() {
        for (int i = 0; i < size; i++) {
            printMapnumber(i);
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + SPACE_MAP_SYMMBOL);
            }
            System.out.println();
        }
    }

    private static void printMapnumber(int i) {
        System.out.print(i + 1 + SPACE_MAP_SYMMBOL);
    }

    private static void printHeader() {
        System.out.print(MAP_FIRST_SYMBOL + SPACE_MAP_SYMMBOL);
        for (int i = 0; i < size; i++) {
            printMapnumber(i);
        }
        System.out.println();
    }

}


