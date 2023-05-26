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
        // swap
        if (rows1 == rows2 + 1 || rows1 == rows2 - 1) {
            if (column1 == column2 + 1 || column1 == column2 - 1) {
                int temp = board[rows1][column1];
                board[rows1][column1] = board[rows2][column2];
                board[rows2][column2] = temp;
            }else{
                System.out.println("Invalid. Try Again.");
                rows1 = sc.nextInt();
                column1 = sc.nextInt();
                rows2 = sc.nextInt();
                column2 = sc.nextInt();
                printBoard(board);
            }
        }else{
            System.out.println("Invalid. Try Again.");
            rows1 = sc.nextInt();
            column1 = sc.nextInt();
            rows2 = sc.nextInt();
            column2 = sc.nextInt();
            printBoard(board);
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