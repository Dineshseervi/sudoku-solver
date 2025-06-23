package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuSolverTest {

    @Test
    public void testGivenEasyBoard() {
        int[][] board = {
                {0, 1, 3, 8, 0, 0, 4, 0, 5},
                {0, 2, 4, 6, 0, 5, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 9, 3, 0},
                {4, 9, 0, 3, 0, 6, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 5, 0, 0},
                {0, 0, 0, 7, 0, 1, 0, 9, 3},
                {0, 6, 9, 0, 0, 0, 7, 4, 0},
                {0, 0, 0, 2, 0, 7, 6, 8, 0},
                {1, 0, 2, 0, 0, 8, 3, 5, 0}
        };
        SudokuSolver solver = new SudokuSolver(SolverFactory.getSolver(SudokoLevel.EASY));
        assertTrue(solver.solve(board));
        solver.printBoard(board);
    }

    @Test
    public void testEasyBoard() {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        SudokuSolver solver = new SudokuSolver(SolverFactory.getSolver(SudokoLevel.EASY));
        assertTrue(solver.solve(board));
        solver.printBoard(board);
    }

    @Test
    public void testGivenDifficultBoard() {
        int[][] board = {
                {0, 0, 2, 0, 0, 0, 0, 4, 1},
                {0, 0, 0, 0, 8, 2, 0, 7, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 9},
                {2, 0, 0, 0, 7, 9, 3, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 6, 8, 1, 0, 0, 0, 4},
                {1, 0, 0, 0, 9, 0, 0, 0, 0},
                {0, 6, 0, 4, 3, 0, 0, 0, 0},
                {8, 5, 0, 0, 0, 0, 4, 0, 0}
        };
        SudokuSolver solver = new SudokuSolver(SolverFactory.getSolver(SudokoLevel.DIFFICULT));
        assertTrue(solver.solve(board));
        solver.printBoard(board);
    }

    @Test
    public void testDifficultBoard() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 3, 5, 0, 0, 0},
                {0, 0, 0, 7, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 9, 0, 0, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 2, 0, 0},
                {3, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        SudokuSolver solver = new SudokuSolver(SolverFactory.getSolver(SudokoLevel.DIFFICULT));
        assertTrue(solver.solve(board));
        solver.printBoard(board);
    }

    @Test
    public void testEasyBoardInvalid() {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 7, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {6, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        SudokuSolver solver = new SudokuSolver(SolverFactory.getSolver(SudokoLevel.EASY));
        assertFalse(solver.solve(board));
        solver.printBoard(board);
    }

    @Test
    public void testEasyBoardInvalidDifficult() {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 7, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {6, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        SudokuSolver solver = new SudokuSolver(SolverFactory.getSolver(SudokoLevel.DIFFICULT));
        assertFalse(solver.solve(board));
        solver.printBoard(board);
    }

    @Test
    public void testEasyBoardInvalidBoardSize() {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 7},
                {0, 9, 8, 0, 0, 0, 0, 6},
                {8, 0, 0, 0, 6, 0, 0, 0},
                {4, 0, 0, 8, 0, 3, 0, 0},
                {7, 0, 0, 0, 2, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 2, 8},
                {0, 0, 0, 4, 1, 9, 0, 0},
                {6, 0, 0, 0, 8, 0, 0, 7}
        };
        SudokuSolver solver = new SudokuSolver(SolverFactory.getSolver(SudokoLevel.EASY));
        assertThrows(RuntimeException.class, () -> {
            solver.solve(board);
        });
        solver.printBoard(board);

    }
}
