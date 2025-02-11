package com.dirk.SudokuGenerator;

import java.util.ArrayList;

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

    public static int[] getPossibleNumbers(int[][] sudoku, int x, int y) {
        int sudokuSize = sudoku.length;
        var possibleNumbers = new ArrayList<Integer>();

        for (int i = 1; i <= sudokuSize; i++) {
            if (isValidPlacementForNumber(sudoku, x, y, i)) {
                possibleNumbers.add(i);
            }
        }

        return possibleNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getCellWithLeastPossibleNumbers(int[][] sudoku) {
        int sudokuSize = sudoku.length;
        int[] cell = new int[]{-1, -1};
        int minPossibleNumbers = sudokuSize + 1;

        for (int x = 0; x < sudokuSize; x++) {
            for (int y = 0; y < sudoku[x].length; y++) {
                if (sudoku[x][y] == 0) {
                    int amountOfPossibleNumbers = getPossibleNumbers(sudoku, x, y).length;
                    if (amountOfPossibleNumbers < minPossibleNumbers && amountOfPossibleNumbers > 0) {
                        minPossibleNumbers = amountOfPossibleNumbers;
                        cell[0] = x;
                        cell[1] = y;
                    }
                }
            }
        }

        return cell;
    }
}
