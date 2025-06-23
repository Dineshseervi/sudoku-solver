package org.example.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.SudokuStrategy;

import java.util.HashSet;
import java.util.Set;

public class BacktrackingSetStrategy implements SudokuStrategy {

    // Singleton instance
    private static final BacktrackingSetStrategy instance = new BacktrackingSetStrategy();
    private static final Logger logger = LogManager.getLogger(BacktrackingSetStrategy.class);

    // Private constructor to prevent external instantiation
    private BacktrackingSetStrategy()  {
        if(instance!=null)
        {
            throw new RuntimeException("Instance already created ");
        }
        System.out.println("First time instance  created for BacktrackingSetStrategy");
        //logger.info("First time created");
    }

    // Public method to access the single instance
    public static BacktrackingSetStrategy getInstance() {
        return instance;
    }


    @Override
    public boolean solve(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        if(m!=9 && n!=9)
        {
            throw new RuntimeException("Invalid Board, board size should be 9*9");
        }
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] boxes = new HashSet[9];

        //initialize the set
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int boxIndex = (row / 3) * 3 + (col / 3);
                int num=board[row][col];
                if(num!=0) {
                    rows[row].add(num);
                    cols[col].add(num);
                    boxes[boxIndex].add(num);
                }
            }
        }

        return recursionSolve(board,rows,cols,boxes);
    }

    private boolean recursionSolve(int[][] board,Set<Integer>[] rows,Set<Integer>[] cols,Set<Integer>[] boxes) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num,rows,cols,boxes)) {
                            logger.debug("Placing {} at ({},{})", num, row, col);
                            int boxIndex = (row / 3) * 3 + (col / 3);
                            board[row][col] = num;
                            rows[row].add(num);
                            cols[col].add(num);
                            boxes[boxIndex].add(num);
                            if (solve(board)) {
                                return true;
                            }
                            logger.debug("Backtracking on ({},{})", row, col);
                            board[row][col] = 0;
                            rows[row].remove(num);
                            cols[col].remove(num);
                            boxes[boxIndex].remove(num);
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


    // Becomes constant time (O(1)).
    // Significantly faster for hard or large boards.
    // Scales better if extended to NxN boards.
    private boolean isValid(int[][] board, int row, int col, int num,Set<Integer>[] rows,Set<Integer>[] cols,Set<Integer>[] boxes) {
        // Check row
        if(rows[row].contains(num) )
        {
            return false;
        }

        if(cols[col].contains(num) )
        {
            return false;
        }

        // Check 3x3 sub-grid
        int boxIndex = (row / 3) * 3 + (col / 3);
        if(boxes[boxIndex].contains(num))
        {
            return false;
        }
        return true;
    }



}
