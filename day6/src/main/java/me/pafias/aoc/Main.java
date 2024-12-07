package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static Grid grid;

    public static void setup(List<String> input) {
        final int height = input.size();
        final int width = input.get(0).length();

        grid = new Grid(width, height);

        int y = 0;
        for (String line : input) {
            int x = 0;
            for (char c : line.toCharArray()) {
                grid.getContent().put(new Coordinate(x, y), String.valueOf(c));
                if (c == '^')
                    grid.setGuard(new Guard(x, y));
                else if (c == '#')
                    grid.addObstacle(x, y);
                x++;
            }
            y++;
        }
    }

    public static int part1(List<String> input) {
        setup(input);

        Set<Coordinate> distinctPositions = new HashSet<>();
        distinctPositions.add(grid.getGuard().getPosition()); // add starting position

        while (grid.isWithinBounds(grid.getGuard().getPosition())) {
            Coordinate next = grid.getGuard().peek();
            if (!grid.isWithinBounds(next)) {
                break;
            }
            if (grid.isObstacle(next)) {
                grid.getGuard().turn();
            } else {
                grid.getGuard().walk();
                distinctPositions.add(next);
            }
        }

        return distinctPositions.size();
    }

    public static int part2(List<String> input) {
        setup(input);

        // Part 1 copy
        Set<Coordinate> distinctPositions = new HashSet<>();
        distinctPositions.add(grid.getGuard().getPosition()); // add starting position

        while (grid.isWithinBounds(grid.getGuard().getPosition())) {
            Coordinate next = grid.getGuard().peek();
            if (!grid.isWithinBounds(next)) {
                break;
            }
            if (grid.isObstacle(next)) {
                grid.getGuard().turn();
            } else {
                grid.getGuard().walk();
                distinctPositions.add(next);
            }
        }
        // /

        Set<Coordinate> possibleObstaclePositions = new HashSet<>();

        Set<Coordinate> copy = new HashSet<>(distinctPositions);
        for (Coordinate coord : copy) {
            setup(input);
            grid.addObstacle(coord.x(), coord.y());

            long startTime = System.currentTimeMillis();
            long timeLimit = 2000;

            while (grid.isWithinBounds(grid.getGuard().getPosition())) {
                if (System.currentTimeMillis() - startTime > timeLimit) {
                    possibleObstaclePositions.add(coord);
                    break;
                }
                Coordinate next = grid.getGuard().peek();
                if (!grid.isWithinBounds(next)) {
                    break;
                }
                if (grid.isObstacle(next)) {
                    grid.getGuard().turn();
                } else {
                    grid.getGuard().walk();
                }
            }
        }

        return possibleObstaclePositions.size();
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}