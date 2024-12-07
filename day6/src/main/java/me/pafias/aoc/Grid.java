package me.pafias.aoc;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {

    @Getter
    private final int width, height;

    private Map<Coordinate, String> content = new HashMap<>();

    @Getter
    @Setter
    private Guard guard;

    @Getter
    private final List<Coordinate> obstacles = new ArrayList<>();

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Map<Coordinate, String> getContent() {
        return content;
    }

    public void addObstacle(int x, int y) {
        obstacles.add(new Coordinate(x, y));
    }

    public boolean isObstacle(Coordinate coordinate) {
        return obstacles.contains(coordinate);
    }

    public boolean isWithinBounds(Coordinate position) {
        return content.containsKey(position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sb.append(content.get(new Coordinate(x, y)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
