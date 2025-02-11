package com.dirk.SudokuGenerator;

import com.dirk.SudokuPrinter.ISudokuPrinter;
import com.dirk.SudokuPrinter.WideSudokuPrinter;

import java.util.Random;

public class SequentialSudokuGenerator implements ISudokuGenerator {
    private int sudokuSize;

    public SequentialSudokuGenerator(int sudokuSize) {
        this.sudokuSize = sudokuSize;
    }

    @Override
    public int[][] generateSudoku() {
        Random random = new Random();
        int subSquareSize = (int) Math.sqrt(sudokuSize);
        int[][] sudoku = new int[sudokuSize][sudokuSize];
        ISudokuPrinter sudokuPrinter = new WideSudokuPrinter();

        for (int i = 1; i <= sudokuSize; i++) {
            for (int y = 0; y < subSquareSize; y++) {
                for (int x = 0; x < subSquareSize; x++) {
                    boolean isValidPlacement = false;
                    int newX = 0;
                    int newY = 0;
                    while (!isValidPlacement) {
                        int randomColumn = random.nextInt(subSquareSize);
                        int randomRow = random.nextInt(subSquareSize);
                        newX = x * subSquareSize + randomColumn;
                        newY = y * subSquareSize + randomRow;
                        isValidPlacement = SudokuChecker.isValidPlacementForNumber(sudoku, newX, newY, i);
                    }
                    sudoku[newX][newY] = i;
                    sudokuPrinter.printSudoku(sudoku);
                }
            }
        }

        return sudoku;
    }
}
