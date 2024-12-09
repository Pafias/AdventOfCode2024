package me.pafias.aoc;

import lombok.Getter;

@Getter
public class File implements Block {

    private final int id;

    public File(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
