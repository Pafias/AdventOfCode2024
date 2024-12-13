package me.pafias.aoc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trail {

    private Coordinate coordinate;
    private int height;

    public boolean isTrailhead() {
        return height == 0;
    }

    public boolean isEnd() {
        return height == 9;
    }

    public boolean isClimbable(Trail other) {
        return other.height == height + 1;
    }

}
