package org.example;

public class SudokuSolver {

    private SudokuStrategy strategy;
    public SudokuSolver(SudokuStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean solve(int[][] board) {
        return strategy.solve(board);
    }


    public void printBoard(int[][] board) {
        System.out.println("\nFinal Sudoku Board:");
        int n=board.length;
        int m=board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("---------------------");
    }
}
