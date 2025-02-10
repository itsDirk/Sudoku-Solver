package com.dirk;

import com.dirk.SudokuGenerator.ISudokuGenerator;
import com.dirk.SudokuGenerator.RandomSudokuGenerator;
import com.dirk.SudokuGenerator.SequentialSudokuGenerator;
import com.dirk.SudokuPrinter.ISudokuPrinter;
import com.dirk.SudokuPrinter.ThinSudokuPrinter;
import com.dirk.SudokuPrinter.WideSudokuPrinter;

public class Sudoku {
    private int sudokuSize = 9;
    private int[][] sudoku;

    public Sudoku() {
        ISudokuGenerator sudokuGenerator = new SequentialSudokuGenerator(sudokuSize);
        sudoku = sudokuGenerator.generateSudoku();
    }

    public void printPuzzle() {
        ISudokuPrinter sudokuPrinter = new WideSudokuPrinter();
        sudokuPrinter.printSudoku(sudoku);
    }


}
