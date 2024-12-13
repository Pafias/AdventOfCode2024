package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static Map map;

    public static int part1(List<String> input) {
        map = me.pafias.aoc.Map.fromInput(input);

        int sum = 0;

        for (Trail trail : map.getTrails().values()) {
            if (trail.isTrailhead()) {
                int possiblePaths = 0; // "score"
                Set<Trail> neighbors = map.getNeighbors(trail.getCoordinate());
                Set<Trail> climbableNeighbors = neighbors.stream().filter(trail::isClimbable).collect(Collectors.toSet());
                for (Trail neighbor : climbableNeighbors) {
                    boolean validPath = true;
                    for (int i = 2; i <= 9; i++) {
                        int finalI = i;
                        if (!climbableNeighbors.stream().anyMatch(n -> n.getHeight() == finalI)) {
                            validPath = false;
                            break;
                        }
                    }
                    if (validPath) {
                        possiblePaths++;
                    }
                }
                sum += possiblePaths;
            }
        }

        return sum;
    }

    public static int part2(List<String> input) {
        return -1;
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}