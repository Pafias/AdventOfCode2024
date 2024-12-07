package me.pafias.aoc;

import java.util.Arrays;
import java.util.List;

public class Square {

    private char a, b, c;
    private char d, e, f;
    private char g, h, i;

    public Square(
            char a, char b, char c,
            char d, char e, char f,
            char g, char h, char i
    ) {
        this.a = a; // M or S
        this.b = b;
        this.c = c; // M or S

        this.d = d;
        this.e = e; // A
        this.f = f;

        this.g = g; // M or S
        this.h = h;
        this.i = i; // M or S
    }

    public boolean isX_MAS() {
//        // Top and bottom must be M or S
//        if (a != 'M' && a != 'S') return false;
//        if (c != 'M' && c != 'S') return false;
//        if (g != 'M' && g != 'S') return false;
//        if (i != 'M' && i != 'S') return false;
//
//        // Center must be A
//        if (e != 'A') return false;
//
//        // Cannot repeat M or S
//        if (a == g && a == i) return false;
//        if (c == g && c == i) return false;
//        if (g == a && g == c) return false;
//        if (i == a && i == c) return false;
//
//        return true;

        if (!getNeighbors(a).contains('M') && !getNeighbors(a).contains('S') && !getNeighbors(a).contains('A'))
            return false;
        if (!getNeighbors(c).contains('M') && !getNeighbors(c).contains('S') && !getNeighbors(c).contains('A'))
            return false;
        if (!getNeighbors(e).contains('M') && !getNeighbors(e).contains('S') && !getNeighbors(e).contains('A'))
            return false;
        if (!getNeighbors(g).contains('M') && !getNeighbors(g).contains('S') && !getNeighbors(g).contains('A'))
            return false;
        if (!getNeighbors(i).contains('M') && !getNeighbors(i).contains('S') && !getNeighbors(i).contains('A'))
            return false;

        return true;
    }

    private List<Character> getNeighbors(char character) {
        if (character == a) {
            return Arrays.asList(b, d, e);
        } else if (character == b) {
            return Arrays.asList(a, c, d, e, f);
        } else if (character == c) {
            return Arrays.asList(b, e, f);
        } else if (character == d) {
            return Arrays.asList(a, b, e, g, h);
        } else if (character == e) {
            return Arrays.asList(a, b, c, d, f, g, h, i);
        } else if (character == f) {
            return Arrays.asList(b, c, e, h, i);
        } else if (character == g) {
            return Arrays.asList(d, e, h);
        } else if (character == h) {
            return Arrays.asList(d, e, f, g, i);
        } else if (character == i) {
            return Arrays.asList(e, f, h);
        }
        return List.of();
    }

    @Override
    public String toString() {
        return String.format("\n%s%s%s\n%s%s%s\n%s%s%s\n",
                a, b, c,
                d, e, f,
                g, h, i
        );
    }
}
