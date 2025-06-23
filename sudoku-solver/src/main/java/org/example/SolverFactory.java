package org.example;

import org.example.impl.BacktrackingSetStrategy;
import org.example.impl.BacktrackingStrategy;

public class SolverFactory {

    public static SudokuStrategy getSolver(SudokoLevel level)
    {
        SudokuStrategy sudokuStrategy;
         switch(level)
        {
            case EASY:
                sudokuStrategy= BacktrackingStrategy.getInstance();
                break;
            case DIFFICULT:
                sudokuStrategy= BacktrackingSetStrategy.getInstance();
                break;
            default:
                sudokuStrategy=BacktrackingStrategy.getInstance();
        }
        return sudokuStrategy;
    }
}
