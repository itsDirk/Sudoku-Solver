package com.dirk;

import java.util.Random;

public class Sudoku {
    private int sudokuSize = 9;
    private int[][] sudoku = new int[sudokuSize][sudokuSize];

    public Sudoku() {
        generateSudoku();
    }

    public void printPuzzle() {
        SudokuPrinter.printSudoku(sudoku);
    }
    
    private void generateSudoku() {
        Random random = new Random();

        for (int i = 0; i < sudokuSize; i++) {
            for (int j = 0; j < sudokuSize; j++) {
                sudoku[i][j] = random.nextInt(1, sudokuSize + 1);
            }
        }
    }
}
