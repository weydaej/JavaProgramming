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
    
    /* board declaration */
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int games = 0;
        int row;
        int col;
        String P1 = "Player 1";
        String P2 = "Player 2";
        String player1 = " X ";
        String player2 = " O ";
        String currentPlayer = player1;
        String currentPlayerString;
        int moves;
        
        /* testing sandbox */
//        clearBoard();
//        board[0][0] = "   ";    board[0][1] = "   ";    board[0][2] = "   ";
//        board[1][0] = "   ";    board[1][1] = "   ";    board[1][2] = "   ";
//        board[2][0] = "   ";    board[2][1] = "   ";    board[2][2] = "   ";
//        display();
//        System.out.println(isWinPossibleRow(currentPlayer));
            
        do {
            games++;
            moves = 0;
            clearBoard();
            display();
            for (int i = 0; i < 9; i++) { // maximum 9 turns for 9 spaces on the board
                if (i % 2 == 0) {
                    currentPlayer = player1;
                    currentPlayerString = P1;
                } else {
                    currentPlayer = player2;
                    currentPlayerString = P2;
                }
                System.out.printf("\n%s, it's your turn!\n", currentPlayerString);
                    do {
                        row = SafeInput.getRangedInt(in, "Enter your row coordinate", 1, 3) - 1;
                        col = SafeInput.getRangedInt(in, "Enter your column coordinate", 1, 3) - 1;
                    } while (!isValidMove(row, col));
                moves += 1;
                board[row][col] = currentPlayer;
                display();

                if (moves >= 5) { // checks win/tie conditions after the 5th turn
                    if (isWin(currentPlayer)) { 
                        System.out.printf("WINNER WINNER CHICKEN DINNER, %s wins!", currentPlayerString);
                        break;
                    } else if (moves >= 7) {
                        System.out.println("7 or greater");
                        if (isTie()) {
                            System.out.println("TIE");
                            break;
                        }
                    }
                } 

            }
            /* toggle X/O at the end of the game */
            if (player1.equals(" X ")) {
                player1 = " O ";
                player2 = " X ";
            } else {
                player1 = " X ";
                player2 = " O ";
            }
        } while (SafeInput.getYNConfirm(in, "Would you like to play again"));
        System.out.printf("You played %d game(s).\n", games);
    }
    
    /* clears board */
    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = "   "; // reset every slot
            }
        }
    }
    
    /* displays tic tac toe board */
    private static void display() {
        String displayBoard = "";
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (j == COL - 1) { // draw rows
                    displayBoard += board[i][j]; // don't append a pipe for col 3
                } else {
                    displayBoard += board[i][j] + "|"; // append pipe after cols
                }
            }
            if (i != ROW - 1) { // append dividers between rows
                displayBoard += "\n---+---+---\n";
            }
        }
        System.out.println(displayBoard);
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
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                    return true;
            }
        }
        return false;
    }
    
    /**
     * @param player a string that represents the player
     * @return true row win condition
     */
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                    return true;
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
     * @param player a string that represents the player
     * @return true if one of the win conditions are true
     */
    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return true if tie occurs
     */
    private static boolean isTie() {
        int count = 0;
        if (isTieRows()) {
            count++;
        }
        if (isTieCols()) {
            count++;
        }
        if (isTieDiagDown()) {
            count++;
        }
        if (isTieDiagUp()) {
            count++;
        }
        
        if (count >= 3) {
            return true;
        }
        return false;
    }
    
    /**
     * @return true if there is at least an X and O in every row
     */
    private static boolean isTieRows() {
        int countX = 0;
        int countO = 0;
        int numDeadWinVectors = 0;
        for (int i = 0; i < ROW; i++) {
            countX = 0;
            countO = 0;
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" X ")) {
                    countX++;
                } else if (board[i][j].equals(" O ")) {
                    countO++;
                }
                if (countX >= 1 && countO >= 1) {
                    numDeadWinVectors++;
                }
            }
        }
        if (numDeadWinVectors >= 3) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return true if there is at least an X and O in every column
     */
    private static boolean isTieCols() {
        int countX = 0;
        int countO = 0;
        int numDeadWinVectors = 0;
        for (int i = 0; i < ROW; i++) {
            countX = 0;
            countO = 0;
            for (int j = 0; j < COL; j++) {
                if (board[j][i].equals(" X ")) {
                    countX++;
                } else if (board[j][i].equals(" O ")) {
                    countO++;
                }
                if (countX >= 1 && countO >= 1) {
                    numDeadWinVectors++;
                }
            }
        }
        if (numDeadWinVectors >= 3) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return true if there is an X and O in the diagonal down
     */
    private static boolean isTieDiagDown() {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < ROW; i++) {
            if (board[i][i].equals(" X ")) {
                countX++;
            } else if (board[i][i].equals(" O ")) {
                countO++;
            }
        }
        if (countX >= 1 && countO >= 1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return true if there is an X and O in the diagonal up
     */
    private static boolean isTieDiagUp() {
        int countX = 0;
        int countO = 0;
        if (board[0][2].equals(" X ")) {
            countX++;
        } else if (board[0][2].equals(" O ")) {
            countO++;
        }
        if (board[1][1].equals(" X ")) {
            countX++;
        } else if (board[1][1].equals(" O ")) {
            countO++;
        }
        if (board[2][0].equals(" X ")) {
            countX++;
        } else if (board[2][0].equals(" O ")) {
            countO++;
        }
        if (countX >= 1 && countO >= 1) {
            return true;
        } else {
            return false;
        }
    }
}