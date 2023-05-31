import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class numberslidinggame { 
    public static final String RESET = "\u001B[0m";
    public static final String REDBKGND = "\u001B[41m";
    public static final String GREEN = "\u001B[42m";
    public static final String RED1 = "\u001B[38;5;160m";
    public static final String RED2 = "\u001B[38;5;196m";
    public static final String BOLD = "\u001b[1m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int[][] board = new int[4][4];
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 16; i++) {//Creates array list
            numbers.add(i);

        }

        Collections.shuffle(numbers);
        for (int i = 0; i < board.length; i++) {// create grid from array
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = numbers.get(count);
                count++;

            }
        }
        System.out.println(BOLD + RED2 + "                _\\|-|-|-|-|-|-|/_");
        System.out.println("               ~_ " + RED1 + "Number  Slide" + RED2 + " _~");
        System.out.println(RED2 + "                 /|-|-|-|-|-|-|\\");
        System.out.println();
        printBoard(board);
        System.out.print(RESET);
        System.out.println("                 BEGIN SWAPPING");
        System.out.println("Give the y then x coordinate of the blank position");
        System.out.println("Give the y and x position of the number you wish to swap");
        // get coordinates
        int rows1 = sc.nextInt();// y coordinate 1
        int column1 = sc.nextInt();// x coordinate 1
        int rows2 = sc.nextInt();// y coordinate 2
        int column2 = sc.nextInt();// x coordinate 2
        // swap
        int movesMade = 0;
        boolean isSolved = false;// if game is completed

        while (isSolved == false) {
            if (board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 && board[0][3] == 4 && board[1][0] == 5
                    && board[1][1] == 6 && board[1][2] == 7 && board[1][3] == 8 && board[2][0] == 9 && board[2][1] == 10
                    && board[2][2] == 11 && board[2][3] == 12 && board[3][0] == 13 && board[3][1] == 14
                    && board[3][2] == 15 && board[3][3] == 0) {// win condition
                isSolved = true;
            }
            if ((rows1 == rows2 + 1 || rows1 == rows2 - 1 || rows1 == rows2)
                    && (column1 == column2 + 1 || column1 == column2 - 1 || column1 == column2)
                    && (board[rows1][column1] == 0 || board[rows2][column2] == 0)) {// Input requirements
                // Swap code
                int temp = board[rows1][column1];
                board[rows1][column1] = board[rows2][column2];
                board[rows2][column2] = temp;
                // Move counter for score
                movesMade++;
                System.out.println("Moves: " + movesMade);
                printBoard(board);
                System.out.print(RESET);

            } else {
                System.out.println("Invalid. Try Again.");// improper input
            }
            // input
            rows1 = sc.nextInt();
            column1 = sc.nextInt();
            rows2 = sc.nextInt();
            column2 = sc.nextInt();

        }
        // Solved board
        if(movesMade > 50){
            System.out.println("Wow that took you a while...");
        }
        System.out.print(GREEN);
        printBoard(board);
        System.out.print(RESET);
        System.out.print("Moves: " + movesMade);

    }
/**
 * Prints out board
 * Changes 0 to a blank space for swapping
 * @param board
 */
    public static void printBoard(int[][] board) {// print out grid
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {// spacing
                if (board[i][j] == board[i][0] || board[i][j] == board[i][0] || board[i][j] == board[i][0]
                        || board[i][j] == board[i][0]) {
                    System.out.print(RESET + "                ");
                    System.out.print(REDBKGND);
                }
                if (board[i][j] == 0) {
                    System.out.printf(" %2.5s ", " ");// blank space for shuffle
                } else {
                    System.out.printf(" %2.5s ", board[i][j]);// Numbers 1 - 15
                    
                }
            }
            System.out.println(RESET);
        }
    }

}