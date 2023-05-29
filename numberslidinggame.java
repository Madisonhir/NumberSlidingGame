import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class numberslidinggame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int[][] board = new int[4][4];
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            numbers.add(i);

        }

        Collections.shuffle(numbers);
        for (int i = 0; i < board.length; i++) {// create grid
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = numbers.get(count);
                count++;

            }
        }

        printBoard(board);
        System.out.println("BEGIN SWAPPING");
        // get coordinates
        int rows1 = sc.nextInt();
        int column1 = sc.nextInt();
        int rows2 = sc.nextInt();
        int column2 = sc.nextInt();
        boolean isSolved = false;
        // swap
        while (isSolved == false) {
            if (board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 && board[0][3] == 4 && board[1][0] == 5
                    && board[1][1] == 6 && board[1][2] == 7 && board[1][3] == 8 && board[2][0] == 9 && board[2][1] == 10
                    && board[2][2] == 11 && board[2][3] == 12 && board[3][0] == 13 && board[3][1] == 14
                    && board[3][2] == 15 && board[3][3] == 0) {
                isSolved = true;
            }
            if ((rows1 == rows2 + 1 || rows1 == rows2 - 1 || rows1 == rows2)
                    && (column1 == column2 + 1 || column1 == column2 - 1 || column1 == column2)
                    && (board[rows1][column1] == 0 || board[rows2][column2] == 0)) {
                int temp = board[rows1][column1];
                board[rows1][column1] = board[rows2][column2];
                board[rows2][column2] = temp;
                printBoard(board);
            } else {
                System.out.println("Invalid. Try Again.");
                rows1 = sc.nextInt();
                column1 = sc.nextInt();
                rows2 = sc.nextInt();
                column2 = sc.nextInt();

            }

            rows1 = sc.nextInt();
            column1 = sc.nextInt();
            rows2 = sc.nextInt();
            column2 = sc.nextInt();

        }

    }

    public static void printBoard(int[][] board) {// print out grid
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {// spacing
                if (board[i][j] == 0) {
                    System.out.printf(" %2s ", " ");
                } else {
                    System.out.printf(" %2s ", board[i][j]);
                }
            }
            System.out.println();
        }
    }

}