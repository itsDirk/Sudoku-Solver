package com.dirk.SudokuGenerator;

import com.dirk.SudokuPrinter.SudokuCell;
import com.dirk.SudokuPrinter.WideSudokuPrinter;

import java.util.Random;

public class RecursiveSudokuGenerator implements ISudokuGenerator {
    private final int sudokuSize;
    private final Random random;

    public RecursiveSudokuGenerator(int sudokuSize) {
        if (sudokuSize < 1 || sudokuSize > 16 || sudokuSize % Math.sqrt(sudokuSize) != 0) {
            throw new IllegalArgumentException("Sudoku size must be a positive integer (max 16) and a squared number.");
        }
        this.sudokuSize = sudokuSize;
        this.random = new Random();
    }

    @Override
    public int[][] generateSudoku() {
        int[][] sudoku = null;

        while (!SudokuChecker.isValidSudoku(sudoku)) {
            sudoku = recursiveSudoku(getEmptySudoku());
        }

        return sudoku;
    }

    private int[][] getEmptySudoku() {
        int[][] sudoku = new int[sudokuSize][sudokuSize];
        for (int i = 0; i < sudokuSize; i++) {
            for (int j = 0; j < sudokuSize; j++) {
                sudoku[i][j] = 0;
            }
        }
        return sudoku;
    }

    private int[][] recursiveSudoku(int[][] sudoku) {
        SudokuCell cellWithLeastPossibleNumbers = SudokuChecker.getCellWithLeastPossibleNumbers(sudoku);

        if (cellWithLeastPossibleNumbers.x == -1) {
            return sudoku;
        }

        int x = cellWithLeastPossibleNumbers.x;
        int y = cellWithLeastPossibleNumbers.y;

        int[] possibleNumbers = SudokuChecker.getPossibleNumbers(sudoku, x, y);

        sudoku[x][y] = possibleNumbers[random.nextInt(possibleNumbers.length)];
        return recursiveSudoku(sudoku);
    }
}
