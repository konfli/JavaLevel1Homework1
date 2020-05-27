import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static int fieldSize = 5;
    public static int winSize = 4;
    public static int offset = fieldSize - winSize + 1;
    public static char playerSign = 'X';
    public static char computerSign = 'O';


    public static void main(String[] args) {

        playTicTokToe();
    }

    static void playTicTokToe() {
        char[][] field = getField();
        drawField(field);
        char currentPlayerSign = playerSign;
        String currentPlayerName = "Player";

        boolean isWin;
        do {
            move(field, currentPlayerSign);
            isWin = checkWin(field, currentPlayerSign);

            if (!isWin) {
                currentPlayerSign = currentPlayerSign == playerSign ? computerSign : playerSign;
                currentPlayerName = currentPlayerSign == playerSign ? "Player" : "Computer";
                drawField(field);
            }
        } while (!isWin);

        System.out.println(String.format("Congrats!!! You are winner Mr. %s", currentPlayerName));

        drawField(field);
    }

    static boolean checkWin(char[][] field, char currentPlayerSign) {
        for (int column = 0; column < offset; column++) {
            for (int row = 0; row < offset; row++) {
                if (checkDiagonalWIn(field, currentPlayerSign, column, row) || checkLanesWin(field, currentPlayerSign, column, row))
                    return true;
                else if (isFieldFull(field)) System.out.println("It\'s Draw");
            }
        }
        return false;
    }

    static boolean checkLanesWin(char[][] field, char currentPlayerSign, int offsetX, int offsetY) {
        boolean columns, rows;
        for (int column = offsetX; column < winSize + offsetX; column++) {
            columns = true;
            rows = true;
            for (int row = offsetY; row < winSize + offsetY; row++) {
                columns &= field[column][row] == currentPlayerSign;
                rows &= (field[row][column] == currentPlayerSign);
            }

            if (columns || rows) return true;
        }

        return false;
    }

    static boolean checkDiagonalWIn(char[][] field, char currentPlayerSing, int offsetX, int offsetY) {
        boolean fromLeftUpToRightDown, fromLeftDownToRightUp;
        fromLeftUpToRightDown = true;
        fromLeftDownToRightUp = true;
        for (int i = 0; i < winSize; i++) {
            fromLeftUpToRightDown &= (field[i + offsetX][i + offsetY] == currentPlayerSing);
            fromLeftDownToRightUp &= (field[winSize - i - 1 + offsetX][i + offsetY] == currentPlayerSing);
        }

        if (fromLeftUpToRightDown || fromLeftDownToRightUp) return true;

        return false;
    }

    static boolean isFieldFull(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == '-') return false;
            }
        }
        return true;
    }


    static void move(char[][] field, char currentPlayerSign) {
        if (currentPlayerSign == 'X') {
            movePlayer(field);
        } else {
            moveComputer(field);
        }
    }

    static void moveComputer(char[][] field) {
        int x = 0, y = 0;
        boolean computer_win = false;
        boolean player_win = false;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isCellEmpty(field, i, j)) {
                    field[i][j] = playerSign;
                    if (checkWin(field, playerSign)) {
                        x = i;
                        y = j;
                        player_win = true;
                    }
                    field[i][j] = '-';
                }
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isCellEmpty(field, i, j)) {
                    field[i][j] = computerSign;
                    if (checkWin(field, computerSign)) {
                        x = i;
                        y = j;
                        computer_win = true;
                    }
                    field[i][j] = '-';
                }
            }
        }
        if (!computer_win && !player_win) {
            do {
                Random random = new Random();
                x = random.nextInt(fieldSize);
                y = random.nextInt(fieldSize);
            }
            while (!isCellEmpty(field, x, y));
        }
        System.out.println("Computer's move ...");
        System.out.println(String.format("Computer decided choose coordinates [%s, %s]", y + 1, x + 1));
        field[x][y] = computerSign;
    }

    static void movePlayer(char[][] field) {
        int x;
        int y;
        boolean isEmptyCell;
        Scanner scanner = new Scanner(System.in);
        do {
            boolean isCorrectCoordinates;
            do {
                System.out.println(String.format("Input Y-coordinates in range [1 ; %s]", fieldSize));
                y = scanner.nextInt() - 1;
                System.out.println(String.format("Input X-coordinates in range [1 ; %s]", fieldSize));
                x = scanner.nextInt() - 1;

                isCorrectCoordinates = checkCoordinates(y, x);
                notifyIncorrectCoordinates(isCorrectCoordinates);

            } while (!isCorrectCoordinates);

            isEmptyCell = isCellEmpty(field, x, y);
            notifyOccupiedCell(isEmptyCell, x, y);
        } while (!isCellEmpty(field, x, y));

        field[x][y] = playerSign;

    }

    static boolean isCellEmpty(char[][] field, int x, int y) {
        return field[x][y] == '-';
    }

    static void notifyOccupiedCell(boolean isOccupied, int x, int y) {
        if (!isOccupied) {
            System.out.println(String.format("Input coordinates are incorrect. Cell of coordinates [%s, %s] is already occupied", y + 1, x + 1));
        }
    }

    static boolean checkCoordinates(int x, int y) {
        return (x >= 0 && x <= fieldSize - 1) && (y >= 0 && y <= fieldSize - 1);
    }

    static void notifyIncorrectCoordinates(boolean isCorrect) {
        if (!isCorrect) {
            System.out.println(String.format("Input coordinates are incorrect. Available coordinates in range [1 ; %s]", fieldSize));
        }
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static char[][] getField() {
        char[][] field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = '-';
            }
        }
        return field;
    }
}