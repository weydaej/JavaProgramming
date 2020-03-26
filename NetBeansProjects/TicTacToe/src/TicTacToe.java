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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SafeInput.getRangedInt(in, "", 0, 0);
        
    }
    
    /* clears board */
    private static void clearBoard() {
        
    }
    
    /* displays tic tac toe board */
    private static void display() {
        
    }
    
    /**
     * @param row an integer representing the row
     * @param col an integer representing the column
     * @return true if valid move
     */
    private static boolean isValidMove(int row, int col) {
        
    }
    
    /**
     * @param player a string that represents the player
     * @return true column win condition
     */
    private static boolean isColWin(String player) {
        
    }
    
    /**
     * @param player a string that represents the player
     * @return true row win condition
     */
    private static boolean isRowWin(String player) {
        
    }
    
    /**
     * @param player a string that represents the player
     * @return true diagonal win condition
     */
    private static boolean isDiagonalWin(String player) {
        
    }
    
    /**
     * @return true if players tie
     */
    private static boolean isTie() {
        
    }
}