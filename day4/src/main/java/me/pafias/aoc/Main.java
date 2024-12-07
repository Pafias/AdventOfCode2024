package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    static String xmas = "XMAS";
    static String xmasBackwards = "SAMX";

    private static boolean detectXMAS(String input) {
        return input.equals(xmas) || input.equals(xmasBackwards);
    }

    public static int part1(List<String> lines) {

        Grid grid = new Grid(lines);

        System.out.println("---------- Horizontal check ----------");

        // Horizontal check
        int horizontalOccurences = 0;
        for (String line : grid.getRows()) {
            for (int i = 0; i < line.length(); i++) {
                if (i + 4 > line.length()) {
                    break;
                }
                String substring = line.substring(i, i + 4);
                if (detectXMAS(substring)) {
                    horizontalOccurences++;
                }
            }
        }
        System.out.println("Horizontal occurences: " + horizontalOccurences);
        System.out.println();
        System.out.println("---------- Vertical check ----------");

        // Vertical check
        int verticalOccurences = 0;
        for (String column : grid.getColumns()) {
            for (int i = 0; i < column.length(); i++) {
                if (i + 4 > column.length()) {
                    break;
                }
                String substring = column.substring(i, i + 4);
                if (detectXMAS(substring)) {
                    verticalOccurences++;
                }
            }
        }

        System.out.println("Vertical occurences: " + verticalOccurences);
        System.out.println();
        System.out.println("---------- Diagonal check ----------");

        // Diagonal check
        int diagonalOccurences = 0;
        for (String diagonal : grid.getDiagonals()) {
            for (int i = 0; i < diagonal.length(); i++) {
                if (i + 4 > diagonal.length()) {
                    break;
                }
                String substring = diagonal.substring(i, i + 4);
                if (detectXMAS(substring)) {
                    diagonalOccurences++;
                }
            }
        }

        System.out.println("Diagonal occurences: " + diagonalOccurences);

        System.out.println();

        int occurences = horizontalOccurences + verticalOccurences + diagonalOccurences;
        System.out.println("Total occurences: " + occurences);
        return occurences;
    }

    public static int part2(List<String> lines) {

        Grid grid = new Grid(lines);

        int occurrences = 0;

        for (Square square : grid.getSquares()) {
            if (square.isX_MAS()) {
                occurrences++;
            }
        }

        System.out.println("Total X-MAS square occurences: " + occurrences);

        return occurrences;
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}