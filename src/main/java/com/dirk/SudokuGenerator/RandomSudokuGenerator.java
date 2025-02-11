package com.dirk.SudokuGenerator;

import com.dirk.SudokuPrinter.ISudokuPrinter;
import com.dirk.SudokuPrinter.ThinSudokuPrinter;
import com.dirk.SudokuPrinter.WideSudokuPrinter;

import java.util.Random;

public class RandomSudokuGenerator implements ISudokuGenerator {
    private int sudokuSize;

    public RandomSudokuGenerator(int sudokuSize) {
        this.sudokuSize = sudokuSize;
    }

    @Override
    public int[][] generateSudoku() {
        Random random = new Random();
        int[][] sudoku = new int[sudokuSize][sudokuSize];
        ISudokuPrinter sudokuPrinter = new WideSudokuPrinter();

        for (int y = 0; y < sudokuSize; y++) {
            for (int x = 0; x < sudokuSize; x++) {
                boolean isValidNumber = false;
                int number = 0;
                while (!isValidNumber) {
                    number = random.nextInt(1, sudokuSize + 1);
                    isValidNumber = SudokuChecker.isValidPlacementForNumber(sudoku, x, y, number);
                }
                sudoku[x][y] = number;
                sudokuPrinter.printSudoku(sudoku);
            }
        }

        return sudoku;
    }
}
