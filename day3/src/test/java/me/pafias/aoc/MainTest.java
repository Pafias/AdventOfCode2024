package me.pafias.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void part1Example() throws Exception {
        assertEquals(161, Main.part1(Main.readFileLines("/example.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals(178794710, Main.part1(Main.readFileLines("/input.txt")));
    }

    @Test
    void part2Example() throws Exception {
        assertEquals(0, Main.part2(Main.readFileLines("/example.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals(0, Main.part2(Main.readFileLines("/input.txt")));
    }

}