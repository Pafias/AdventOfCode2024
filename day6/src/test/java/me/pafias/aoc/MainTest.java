package me.pafias.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void part1Example() throws Exception {
        assertEquals(41, Main.part1(Main.readFileLines("/example.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals(5177, Main.part1(Main.readFileLines("/input.txt")));
    }

    @Test
    void part2Example() throws Exception {
        assertEquals(6, Main.part2(Main.readFileLines("/example.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals(1686, Main.part2(Main.readFileLines("/input.txt")));
    }

}