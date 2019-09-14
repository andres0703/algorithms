package test;

import java.util.Scanner;

public class TicTacToe {
    private int[][] board;

    public TicTacToe() {
        board = new int[3][3];
    }
/*


//...
System.out.print("Enter a number: ")
Scanner in = new Scanner(System.in);
String s = in.nextLine();
 */

    public void play() {
        while (!isFull()) {
            System.out.print("Enter a number: ");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            int row =0;
        }
    }


//    public int[] userPut(int row, int col) {
//
//    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 1) sb.append("X");
                else if (board[i][j] == 2) sb.append("O");
                else if (board[i][j] == 0) sb.append("-");
                if (j != 2) sb.append("|");
            }
            System.out.println(sb.toString());
        }
    }

    private void AImove() throws IndexOutOfBoundsException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 2;
                    return;
                }
            }
        }
        throw new IndexOutOfBoundsException("Board is full");
    }

    private void placeToken(int row, int col, boolean isUser) {
        if (isUser) {
            board[row][col] = 1;
        } else {
            board[row][col] = 2;
        }
    }

    public boolean isFull() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) count++;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        //ttt.print();
        ttt.placeToken(0, 1, true);
        ttt.placeToken(2, 1, false);
        //ttt.print();
        for (int i = 0; i < 10; i++) {
            ttt.AImove();
            ttt.print();
            System.out.println(ttt.isFull());
            System.out.println();
        }

    }
}
