package me.pafias.aoc;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Rule {

    private final int x;
    private final int y;

    public Rule(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Rule fromInput(String input) {
        String[] split = input.split(Pattern.quote("|"));
        return new Rule(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    @Override
    public String toString() {
        return x + "|" + y;
    }

}
