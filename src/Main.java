import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char board[][] = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        initBoard(board);
        printBoard(board);
        int index = 0;
        while (true) {
            char player;
            if (index % 2 == 0) {
                player = 'X';
            } else {
                player = 'O';
            }
            System.out.println(player + ", bitte Stelle im Board eingeben: ");
            int i, j;
            try {
                i = scanner.nextInt();
                j = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                System.out.println("Fehlerhafte Eingabe!");
                continue;
            }
            if (i >= 0 && j >= 0 && i < board.length && j < board[i].length) {
                if (board[i][j] == '-') {
                    board[i][j] = player;
                    printBoard(board);
                    if(hasWon(board, player)) {
                        System.out.println(player + " hat gewonnen.");
                        System.exit(0);
                    }
                    index++;
                } else {
                    System.out.println("Dieses Feld ist bereits belegt!");
                }
            } else {
                System.out.println("Die eingegebene Stelle befindet sich außerhalb vom Board!");
            }
        }
    }
    private static void initBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }
    public static boolean hasWon(char[][] board, char player) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
        }
        for (int j = 0; j < board.length; j++) {
            if(board[0][j] == player && board[1][j] == player && board[2][j] == player){
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        } else if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }
        return false;


    }
}
