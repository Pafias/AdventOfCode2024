package me.pafias.aoc;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<String> lines;
    private int MAX_LINE_SIZE;

    public Grid(List<String> lines) {
        this.lines = lines;
        MAX_LINE_SIZE = lines.getFirst().length();
    }

    public List<Square> getSquares() {
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            squares.addAll(get3x3Squares(i));
        }
        return squares;
    }

    public List<Square> get3x3Squares(int row) {
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < MAX_LINE_SIZE; i++) {
            if (i + 3 > MAX_LINE_SIZE) {
                break;
            }
            String line1 = getRow(row);
            String line2 = getRow(row + 1);
            if (line2 == null)
                break;
            String line3 = getRow(row + 2);
            if (line3 == null)
                break;
            squares.add(new Square(
                    line1.charAt(i),
                    line1.charAt(i + 1),
                    line1.charAt(i + 2),
                    line2.charAt(i),
                    line2.charAt(i + 1),
                    line2.charAt(i + 2),
                    line3.charAt(i),
                    line3.charAt(i + 1),
                    line3.charAt(i + 2)
            ));
        }
        return squares;
    }

    public List<String> getRows() {
        return lines;
    }

    public String getRow(int row) {
        try {
            return lines.get(row);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        for (int i = 0; i < MAX_LINE_SIZE; i++) {
            columns.add(getColumn(i));
        }
        return columns;
    }

    public String getColumn(int column) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line.charAt(column));
        }
        return sb.toString();
    }

    public List<String> getDiagonals() {
        // What I originally tried

        /*
        List<String> diagonals = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                for (Direction direction : Direction.values()) {
                    diagonals.add(getDiagonal(i, j, direction));
                }
            }
        }
        return diagonals;
        */

        // ChatGPT fix/solution

        List<String> diagonals = new ArrayList<>();

        // Top-left to bottom-right
        for (int row = 0; row < lines.size(); row++) {
            diagonals.add(getDiagonal(row, 0, Direction.TOPLEFT_BOTTOMRIGHT));
        }
        for (int col = 1; col < MAX_LINE_SIZE; col++) {
            diagonals.add(getDiagonal(0, col, Direction.TOPLEFT_BOTTOMRIGHT));
        }

        // Top-right to bottom-left
        for (int row = 0; row < lines.size(); row++) {
            diagonals.add(getDiagonal(row, MAX_LINE_SIZE - 1, Direction.TOPRIGHT_BOTTOMLEFT));
        }
        for (int col = MAX_LINE_SIZE - 2; col >= 0; col--) {
            diagonals.add(getDiagonal(0, col, Direction.TOPRIGHT_BOTTOMLEFT));
        }

        return diagonals;
    }

    public String getDiagonal(int row, int column, Direction direction) {
        // Copilot helped autocomplete this method
        StringBuilder sb = new StringBuilder();
        int i = row;
        int j = column;
        while (i >= 0 && i < lines.size() && j >= 0 && j < lines.get(i).length()) {
            sb.append(lines.get(i).charAt(j));
            switch (direction) {
                case TOPLEFT_BOTTOMRIGHT -> {
                    i++;
                    j++;
                }
                case TOPRIGHT_BOTTOMLEFT -> {
                    i++;
                    j--;
                }
                case BOTTOMLEFT_TOPRIGHT -> {
                    i--;
                    j++;
                }
                case BOTTOMRIGHT_TOPLEFT -> {
                    i--;
                    j--;
                }
            }
        }
        return sb.toString();
    }

    public enum Direction {
        TOPLEFT_BOTTOMRIGHT,
        TOPRIGHT_BOTTOMLEFT,
        BOTTOMLEFT_TOPRIGHT,
        BOTTOMRIGHT_TOPLEFT
    }

}
