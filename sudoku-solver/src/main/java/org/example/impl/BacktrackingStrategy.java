package org.example.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.SudokuStrategy;

public class BacktrackingStrategy implements SudokuStrategy {

    // Singleton instance
    private static final BacktrackingStrategy instance = new BacktrackingStrategy();
    private static final Logger logger = LogManager.getLogger(BacktrackingStrategy.class);

    // Private constructor to prevent external instantiation
    private BacktrackingStrategy()  {
        if(instance!=null)
        {
            throw new RuntimeException("Instance already created ");
        }
        System.out.println("First time instance  created for BacktrackingStrategy");
        //logger.info("First time created");
    }

    // Public method to access the single instance
    public static BacktrackingStrategy getInstance() {
        return instance;
    }

     /**
     * Time complexity : T(k)=O(9^k) , due to backtracking
     * Space complexity: Space=O(81)=O(1)
     * @param board
     * @return
     */
    @Override
    public boolean solve(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        if(m!=9 && n!=9)
        {
            throw new RuntimeException("Invalid Board, board size should be 9*9");
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            logger.debug("Placing {} at ({},{})", num, row, col);
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            logger.debug("Backtracking on ({},{})", row, col);
                            board[row][col] = 0;
                        }else{
                            logger.trace("Cannot place {} at ({},{})", num, row, col);
                        }
                    }

                    logger.debug("No valid number for cell ({},{}), backtracking", row, col);
                    return false;
                }
            }
        }
        logger.info("Sudoku board solved successfully.");
        return true;
    }

   /* private boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
               //This line causes incorrect index access or false validations.
            if (board[row][i] == num || board[i][col] == num ||
                    board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num)
                return false;
        }
        return true;
    }*/

    private boolean isValid(int[][] board, int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }

        return true;
    }



}
