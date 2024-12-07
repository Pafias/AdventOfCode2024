package me.pafias.aoc;

public enum Facing {

    UP,
    RIGHT,
    DOWN,
    LEFT;

    public Facing next() {
        return switch (this) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }

}
