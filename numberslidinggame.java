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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = numbers.get(count);
                count++;

            }
        }

        printBoard(board);
        System.out.println("BEGIN");

        String choice = sc.nextLine();
        int column1 = sc.nextInt();
        int rows1 = sc.nextInt();
        int column2 = sc.nextInt();
        int rows2 = sc.nextInt();
        int i = board[column1][rows1];
        int j = board[column2][rows2];
        swap(numbers,i, j);
        count = 0;
       
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[col].length; col++) {
                board[row][col] = numbers.get(count);
                count++;

            }
        }
        printBoard(board);

    }

    public static void swap(ArrayList<?> array, int i, int j) {
        Collections.swap(array, i, j);

    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 0){
                    System.out.printf(" %2s ", " ");
                }else{
                System.out.printf(" %2s ", board[i][j]);
                }
            }
            System.out.println();
        }
    }

}