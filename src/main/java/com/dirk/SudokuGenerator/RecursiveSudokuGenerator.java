package com.dirk.SudokuGenerator;

import java.util.Random;

public class RecursiveSudokuGenerator implements ISudokuGenerator {
    private int sudokuSize;

    public RecursiveSudokuGenerator(int sudokuSize) {
        this.sudokuSize = sudokuSize;
    }

    @Override
    public int[][] generateSudoku() {
        int[][] sudoku = new int[sudokuSize][sudokuSize];
        for (int i = 0; i < sudokuSize; i++) {
            for (int j = 0; j < sudokuSize; j++) {
                sudoku[i][j] = 0;
            }
        }

        return recursiveSudoku(sudoku);
    }

    private int[][] recursiveSudoku(int[][] sudoku) {
        int[] cellWithLeastPossibleNumbers = SudokuChecker.getCellWithLeastPossibleNumbers(sudoku);

        if (cellWithLeastPossibleNumbers[0] == -1) {
            return sudoku;
        }

        int x = cellWithLeastPossibleNumbers[0];
        int y = cellWithLeastPossibleNumbers[1];
        
        int[] possibleNumbers = SudokuChecker.getPossibleNumbers(sudoku, x, y);
        Random random = new Random();
        sudoku[x][y] = SudokuChecker.getPossibleNumbers(sudoku, x, y)[random.nextInt(possibleNumbers.length)];
        return recursiveSudoku(sudoku);
    }
}
