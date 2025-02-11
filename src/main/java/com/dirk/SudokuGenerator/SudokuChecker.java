package com.dirk.SudokuGenerator;

public class SudokuChecker {
    public static boolean isValidPlacementForNumber(int[][] sudoku, int x, int y, int number) {
        return isUnoccupied(sudoku, x, y) &&
                isValidPlacementInColumn(sudoku, x, number) &&
                isValidPlacementInRow(sudoku, y, number) &&
                isValidPlacementInSquare(sudoku, x, y, number);
    }

    private static boolean isUnoccupied(int[][] sudoku, int x, int y) {
        return sudoku[x][y] == 0;
    }

    private static boolean isValidPlacementInColumn(int[][] sudoku, int x, int number) {
        for (int y = 0; y < sudoku[x].length; y++) {
            if (sudoku[x][y] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidPlacementInRow(int[][] sudoku, int y, int number) {
        for (int x = 0; x < sudoku.length; x++) {
            if (sudoku[x][y] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidPlacementInSquare(int[][] sudoku, int x, int y, int number) {
        int squareSize = (int) Math.sqrt(Math.min(sudoku.length, sudoku[0].length));
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
