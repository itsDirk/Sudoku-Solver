package com.dirk.SudokuPrinter;

import com.dirk.SudokuTile;

public class ThinSudokuPrinter implements ISudokuPrinter{
    @Override
    public void printSudoku(int[][] sudoku) {
        int sudokuSize = sudoku.length;
        int totalLines = sudokuSize * 2 + 1;
        char[][] output = new char[totalLines][totalLines];

        setOutlines(output);
        setNumbers(output, sudoku);

        System.out.println(charArrayToString(output));
    }

    private static char[][] setOutlines(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        input[i][j] = SudokuTile.ThickCornerTopLeft.getSymbol().charAt(0);
                    } else if (j == input.length - 1) {
                        input[i][j] = SudokuTile.ThickCornerTopRight.getSymbol().charAt(0);
                    } else if (j % 6 == 0) {
                        input[i][j] = SudokuTile.ThickTTop.getSymbol().charAt(0);
                    } else {
                        input[i][j] = SudokuTile.ThickHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (i == input.length - 1) {
                    if (j == 0) {
                        input[i][j] = SudokuTile.ThickCornerBottomLeft.getSymbol().charAt(0);
                    } else if (j == input.length - 1) {
                        input[i][j] = SudokuTile.ThickCornerBottomRight.getSymbol().charAt(0);
                    } else if (j % 6 == 0) {
                        input[i][j] = SudokuTile.ThickTBottom.getSymbol().charAt(0);
                    } else {
                        input[i][j] = SudokuTile.ThickHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (i % 6 == 0) {
                    if (j == 0) {
                        input[i][j] = SudokuTile.ThickTLeft.getSymbol().charAt(0);
                    } else if (j == input.length - 1) {
                        input[i][j] = SudokuTile.ThickTRight.getSymbol().charAt(0);
                    } else if (j % 6 == 0) {
                        input[i][j] = SudokuTile.ThickCross.getSymbol().charAt(0);
                    } else {
                        input[i][j] = SudokuTile.ThickHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (i % 2 == 0) {
                    if (j % 6 == 0) {
                        input[i][j] = SudokuTile.ThickVerticalLine.getSymbol().charAt(0);
                    } else if (j % 2 == 0) {
                        input[i][j] = SudokuTile.ThinCross.getSymbol().charAt(0);
                    } else {
                        input[i][j] = SudokuTile.ThinHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (i % 2 == 1) {
                    if (j % 6 == 0) {
                        input[i][j] = SudokuTile.ThickVerticalLine.getSymbol().charAt(0);
                    } else if (j % 2 == 0) {
                        input[i][j] = SudokuTile.ThinVerticalLine.getSymbol().charAt(0);
                    } else {
                        input[i][j] = SudokuTile.Empty.getSymbol().charAt(0);
                    }
                }
            }
        }

        return input;
    }

    private static char[][] setNumbers(char[][] input, int[][] sudoku) {
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input.length; x++) {
                if (x % 2 == 1 && y % 2 == 1) {
                    int sudokuCol = x / 2;
                    int sudokuRow = y / 2;
                    if (sudoku[sudokuRow][sudokuCol] != 0) {
                        input[x][y] = Character.forDigit(sudoku[sudokuRow][sudokuCol], 10);
                    }
                }
            }
        }
        return input;
    }


    private static String charArrayToString(char[][] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                sb.append(input[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
