package com.dirk;

import com.dirk.SudokuGenerator.ISudokuGenerator;
import com.dirk.SudokuGenerator.RecursiveSudokuGenerator;
import com.dirk.SudokuPrinter.ISudokuPrinter;
import com.dirk.SudokuPrinter.WideSudokuPrinter;

public class Sudoku {
    private int sudokuSize = 9;
    private int[][] sudoku;

    public Sudoku() {
        ISudokuGenerator sudokuGenerator = new RecursiveSudokuGenerator(sudokuSize);
        sudoku = sudokuGenerator.generateSudoku();
    }

    public void printPuzzle() {
        if (sudoku == null) {
            System.out.println("Sudoku is null!");
            return;
        }
        new WideSudokuPrinter().printSudoku(sudoku);
    }


}
