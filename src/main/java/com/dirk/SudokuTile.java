package com.dirk;

public enum SudokuTile {
    ThickCornerTopLeft("╔"),
    ThickCornerTopRight("╗"),
    ThickCornerBottomLeft("╚"),
    ThickCornerBottomRight("╝"),
    ThickHorizontalLine("═"),
    ThickVerticalLine("║"),
    ThickTTop("╦"),
    ThickTBottom("╩"),
    ThickTLeft("╠"),
    ThickTRight("╣"),
    ThickCross("╬"),
    
    ThinCornerTopLeft("┌"),
    ThinCornerTopRight("┐"),
    ThinCornerBottomLeft("└"),
    ThinCornerBottomRight("┘"),
    ThinHorizontalLine("─"),
    ThinVerticalLine("│"),
    ThinTTop("┬"),
    ThinTBottom("┴"),
    ThinTLeft("├"),
    ThinTRight("┤"),
    ThinCross("┼"),
    Empty(" ");

    private final String symbol;

    SudokuTile(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
