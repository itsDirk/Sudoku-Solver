package com.dirk.SudokuGenerator;

import com.dirk.SudokuPrinter.ISudokuPrinter;
import com.dirk.SudokuPrinter.ThinSudokuPrinter;

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
        ISudokuPrinter sudokuPrinter = new ThinSudokuPrinter();

        for (int y = 0; y < sudokuSize; y++) {
            for (int x = 0; x < sudokuSize; x++) {
                boolean isValidNumber = false;
                int number = 0;
                while (!isValidNumber) {
                    number = random.nextInt(1, sudokuSize + 1);
                    isValidNumber = isValidPlacementForNumber(sudoku, x, y, number);
                }
                sudoku[x][y] = number;
                sudokuPrinter.printSudoku(sudoku);
            }
        }

        return sudoku;
    }

    private boolean isValidPlacementForNumber(int[][] sudoku, int x, int y, int number) {
        return isValidPlacementInColumn(sudoku, x, number) &&
                isValidPlacementInRow(sudoku, y, number) &&
                isValidPlacementInSquare(sudoku, x, y, number);
    }

    private boolean isValidPlacementInColumn(int[][] sudoku, int x, int number) {
        for (int i = 0; i < sudokuSize; i++) {
            if (sudoku[x][i] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPlacementInRow(int[][] sudoku, int y, int number) {
        for (int x = 0; x < sudokuSize; x++) {
            if (sudoku[x][y] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPlacementInSquare(int[][] sudoku, int x, int y, int number) {
        int squareSize = (int) Math.sqrt(sudokuSize);
        int squareX = x / squareSize;
        int squareY = y / squareSize;

        for (int i = squareX * squareSize; i < squareX * squareSize + squareSize; i++) {
            for (int j = squareY * squareSize; j < squareY * squareSize + squareSize; j++) {
                if (sudoku[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
