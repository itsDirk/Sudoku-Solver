package com.dirk.SudokuPrinter;

import com.dirk.SudokuTile;

public class WideSudokuPrinter implements ISudokuPrinter {
    @Override
    public void printSudoku(int[][] sudoku) {
        int sudokuSize = sudoku.length;
        int width = sudokuSize * 4 + 1;
        int height = sudokuSize * 2 + 1;
        char[][] output = new char[height][width];

        setOutlines(output);
        setNumbers(output, sudoku);

        System.out.println(charArrayToString(output));
    }

    private static char[][] setOutlines(char[][] input) {
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[0].length; x++) {
                if (y == 0) {
                    if (x == 0) {
                        input[y][x] = SudokuTile.ThickCornerTopLeft.getSymbol().charAt(0);
                    } else if (x == input[0].length - 1) {
                        input[y][x] = SudokuTile.ThickCornerTopRight.getSymbol().charAt(0);
                    } else if (x % 12 == 0) {
                        input[y][x] = SudokuTile.ThickTTop.getSymbol().charAt(0);
                    } else {
                        input[y][x] = SudokuTile.ThickHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (y == input.length - 1) {
                    if (x == 0) {
                        input[y][x] = SudokuTile.ThickCornerBottomLeft.getSymbol().charAt(0);
                    } else if (x == input[0].length - 1) {
                        input[y][x] = SudokuTile.ThickCornerBottomRight.getSymbol().charAt(0);
                    } else if (x % 12 == 0) {
                        input[y][x] = SudokuTile.ThickTBottom.getSymbol().charAt(0);
                    } else {
                        input[y][x] = SudokuTile.ThickHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (y % 6 == 0) {
                    if (x == 0) {
                        input[y][x] = SudokuTile.ThickTLeft.getSymbol().charAt(0);
                    } else if (x == input[0].length - 1) {
                        input[y][x] = SudokuTile.ThickTRight.getSymbol().charAt(0);
                    } else if (x % 12 == 0) {
                        input[y][x] = SudokuTile.ThickCross.getSymbol().charAt(0);
                    } else {
                        input[y][x] = SudokuTile.ThickHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (y % 2 == 0) {
                    if (x % 12 == 0) {
                        input[y][x] = SudokuTile.ThickVerticalLine.getSymbol().charAt(0);
                    } else if (x % 4 == 0) {
                        input[y][x] = SudokuTile.ThinCross.getSymbol().charAt(0);
                    } else {
                        input[y][x] = SudokuTile.ThinHorizontalLine.getSymbol().charAt(0);
                    }
                } else if (y % 2 == 1) {
                    if (x % 12 == 0) {
                        input[y][x] = SudokuTile.ThickVerticalLine.getSymbol().charAt(0);
                    } else if (x % 4 == 0) {
                        input[y][x] = SudokuTile.ThinVerticalLine.getSymbol().charAt(0);
                    } else {
                        input[y][x] = SudokuTile.Empty.getSymbol().charAt(0);
                    }
                }
            }
        }

        return input;
    }

    private static char[][] setNumbers(char[][] input, int[][] sudoku) {
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[0].length; x++) {
                if (x % 4 == 2 && y % 2 == 1) {
                    int column = x / 4;
                    int row = y / 2;
                    if (sudoku[column][row] != 0) {
                        input[y][x] = Integer.toHexString(sudoku[column][row]).charAt(0);
                    }
                }
            }
        }
        return input;
    }


    private static String charArrayToString(char[][] input) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[0].length; x++) {
                sb.append(input[y][x]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
