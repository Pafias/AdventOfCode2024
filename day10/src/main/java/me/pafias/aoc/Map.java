package me.pafias.aoc;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Map {

    private final List<String> map;

    public Map(List<String> map) {
        this.map = map;
    }

    public static Map fromInput(List<String> input) {
        Map map = new Map(input);
        int y = 0;
        for (String line : input) {
            int x = 0;
            for (char c : line.toCharArray()) {
                int height = Integer.parseInt(String.valueOf(c));
                map.trails.put(new Coordinate(x, y), new Trail(new Coordinate(x, y), height));
                x++;
            }
            y++;
        }
        return map;
    }

    private java.util.Map<Coordinate, Trail> trails = new HashMap<>();

    public Set<Trail> getTrailheads() {
        return trails.values().stream().filter(Trail::isTrailhead).collect(Collectors.toSet());
    }

    public Set<Trail> getNeighbors(Coordinate coordinate) {
        return trails.values().stream().filter(trail -> {
            int x = trail.getCoordinate().x();
            int y = trail.getCoordinate().x();
            return (x == coordinate.x() - 1 && y == coordinate.y()) ||
                    (x == coordinate.x() + 1 && y == coordinate.y()) ||
                    (x == coordinate.x() && y == coordinate.y() - 1) ||
                    (x == coordinate.x() && y == coordinate.y() + 1);
        }).collect(Collectors.toSet());
    }

}
