package me.pafias.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void part1Example() throws Exception {
        assertEquals(1928, Main.part1(Main.readFileLine("/example.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals(0, Main.part1(Main.readFileLine("/input.txt")));
    }

    @Test
    void part2Example() throws Exception {
        assertEquals(0, Main.part2(Main.readFileLine("/example.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals(0, Main.part2(Main.readFileLine("/input.txt")));
    }

}