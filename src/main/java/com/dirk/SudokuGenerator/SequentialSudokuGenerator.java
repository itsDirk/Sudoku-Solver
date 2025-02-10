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
                        isValidPlacement = isValidPlacementForNumber(sudoku, newX, newY, i);
                    }
                    sudoku[newX][newY] = i;
                    sudokuPrinter.printSudoku(sudoku);
                }
            }
        }

        return sudoku;
    }

    private boolean isValidPlacementForNumber(int[][] sudoku, int x, int y, int number) {
        return isUnoccupied(sudoku, x, y) &&
                isValidPlacementInColumn(sudoku, x, number) &&
                isValidPlacementInRow(sudoku, y, number) &&
                isValidPlacementInSquare(sudoku, x, y, number);
    }

    private boolean isUnoccupied(int[][] sudoku, int x, int y) {
        return sudoku[x][y] == 0;
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
