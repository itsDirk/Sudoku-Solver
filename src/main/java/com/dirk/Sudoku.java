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

        for (int y = 0; y < sudokuSize; y++) {
            for (int x = 0; x < sudokuSize; x++) {
                boolean isValidNumber = false;
                int number = 0;
                while (!isValidNumber) {
                    number = random.nextInt(1, sudokuSize + 1);
                    isValidNumber = isValidPlacementForNumber(x, y, number);
                }
                sudoku[x][y] = number;
                printPuzzle();
            }
        }
    }
    
    private boolean isValidPlacementForNumber(int x, int y, int number) {
        return isValidPlacementInColumn(x, number) && isValidPlacementInRow(y, number);
    }

    private boolean isValidPlacementInColumn(int x, int number) {
        for (int i = 0; i < sudokuSize; i++) {
            if (sudoku[x][i] == number) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidPlacementInRow(int y, int number) {
        for (int i = 0; i < sudokuSize; i++) {
            if (sudoku[i][y] == number) {
                return false;
            }
        }
        return true;
    }
}
