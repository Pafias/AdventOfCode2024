package me.pafias.aoc;

import lombok.Getter;
import lombok.Setter;

public class Guard {

    @Getter
    @Setter
    private Coordinate position;

    @Getter
    @Setter
    private Facing facing;

    public Guard(int x, int y) {
        position = new Coordinate(x, y);
        facing = Facing.UP;
    }

    /**
     * Look at the next coordinate in the direction the guard is facing without changing the guard's position
     *
     * @return the next coordinate
     */
    public Coordinate peek() {
        return switch (facing) {
            case UP -> new Coordinate(position.x(), position.y() - 1);
            case RIGHT -> new Coordinate(position.x() + 1, position.y());
            case DOWN -> new Coordinate(position.x(), position.y() + 1);
            case LEFT -> new Coordinate(position.x() - 1, position.y());
        };
    }

    /**
     * Move the guard one step forward
     *
     * @return the new position
     */
    public Coordinate walk() {
        switch (facing) {
            case UP:
                position = new Coordinate(position.x(), position.y() - 1);
                break;
            case RIGHT:
                position = new Coordinate(position.x() + 1, position.y());
                break;
            case DOWN:
                position = new Coordinate(position.x(), position.y() + 1);
                break;
            case LEFT:
                position = new Coordinate(position.x() - 1, position.y());
                break;
        }
        return position;
    }

    /**
     * Turn the guard 90 degrees to the right
     *
     * @return the new facing
     */
    public Facing turn() {
        facing = facing.next();
        return facing;
    }

}
