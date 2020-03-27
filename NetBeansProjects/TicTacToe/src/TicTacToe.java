/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */
import java.util.Scanner;
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String player1 = " X ";
        String player2 = " O ";
        clearBoard();
        display();
        board[0][0] = " X ";
        board[1][1] = " X ";
        board[2][2] = " X ";
        display();
        System.out.println("DIAG WIN " + isDiagonalWin(player1));
        
        System.out.println("ROW WIN " + isRowWin(player1));
        System.out.println("COL WIN " + isColWin(player1));
    }
    
    /* clears board */
    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = "   ";
            }
        }
    }
    
    /* displays tic tac toe board */
    private static void display() {
        String brd = "";
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (j == COL - 1) {
                    brd += board[i][j];
                } else {
                    brd += board[i][j] + "|";
                }
            }
            if (i != ROW - 1) {
                brd += "\n---+---+---\n";
            }
        }
        System.out.println(brd);
    }
    
    /**
     * @param row an integer representing the row
     * @param col an integer representing the column
     * @return true if valid move
     */
    private static boolean isValidMove(int row, int col) {
        return (board[row][col].equals("   "));
    }
    
    /**
     * @param player a string that represents the player
     * @return true column win condition
     */
    private static boolean isColWin(String player) {
        for (int i = 0; i < ROW; i++) {
            int count = 0;
            for (int j = 0; j < COL; j++) {
                if (board[j][i].equals(player)) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * @param player a string that represents the player
     * @return true row win condition
     */
    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            int count = 0;
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(player)) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * @param player a string that represents the player
     * @return true diagonal win condition
     */
    private static boolean isDiagonalWin(String player) {
        if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) || 
            (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return true if players tie
     */
    private static boolean isTie() {
        return true;
    }
}