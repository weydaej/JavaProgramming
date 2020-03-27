/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author weydaej
 */

/**
 * TODO
 * ---------------------------------------------------------------------------------------
 * Fix isTie()
 * Implement twoInARow() code to help decipher when the game is "over"
 * Play through several games with different win conditions to make sure no bugs
 * Maybe add some stats (player 1 won X # of games, player 2 won X # of games, X # of ties)
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
        int games = 0;
        int row;
        int col;
        String P1 = "Player 1";
        String P2 = "Player 2";
        String player1 = " X ";
        String player2 = " O ";
        String currentPlayer = player1;
        String currentPlayerString;
        do {
            if (games % 2 == 0) { // toggles player every other game
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            games++;
            int moves = 0;
            
            clearBoard();
            display();
            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                    currentPlayer = player1;
                    currentPlayerString = P1;
                } else {
                    currentPlayer = player2;
                    currentPlayerString = P2;
                }
                System.out.printf("%s, it's your turn!\n", currentPlayerString);
                    do {
                        row = SafeInput.getRangedInt(in, "Enter your row coordinate", 1, 3) - 1;
                        col = SafeInput.getRangedInt(in, "Enter your column coordinate", 1, 3) - 1;
                    } while (!isValidMove(row, col));
                moves += 1;
                board[row][col] = currentPlayer;
                display();
                
                if (moves >= 3) {
                    // check for win
                    // check for tie 
                }
                if (isColWin(currentPlayer) || isRowWin(currentPlayer) || isDiagonalWin(currentPlayer) || isTie()) {
                    // announce the win or tie
                    System.out.printf("WINNER WINNER CHICKEN DINNER, %s wins!", currentPlayerString);
                    break;
                }
            }
        } while (SafeInput.getYNConfirm(in, "Would you like to play again"));
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
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (!board[i][j].equals("   ")) {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("All spaces are filled");
            return true;
        } else {
            return false;
        }
    }
    
    private static boolean twoInARow() {
        // returns true if win is still possible
        return false;
    } 
}