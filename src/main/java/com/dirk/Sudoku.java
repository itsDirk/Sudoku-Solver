package com.dirk;

import com.dirk.SudokuGenerator.ISudokuGenerator;
import com.dirk.SudokuGenerator.RandomSudokuGenerator;
import com.dirk.SudokuPrinter.ISudokuPrinter;
import com.dirk.SudokuPrinter.ThinSudokuPrinter;

public class Sudoku {
    private int sudokuSize = 9;
    private int[][] sudoku;

    public Sudoku() {
        ISudokuGenerator sudokuGenerator = new RandomSudokuGenerator(sudokuSize);
        sudoku = sudokuGenerator.generateSudoku();
    }

    public void printPuzzle() {
        ISudokuPrinter sudokuPrinter = new ThinSudokuPrinter();
        sudokuPrinter.printSudoku(sudoku);
    }


}
