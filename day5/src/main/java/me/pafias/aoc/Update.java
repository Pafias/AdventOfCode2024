package me.pafias.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Update {

    private final List<Integer> numbers;

    public Update(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Update fromInput(String input) {
        String[] split = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) numbers.add(Integer.parseInt(s.trim()));
        return new Update(numbers);
    }

    public int getMiddleNumber() {
        return numbers.get(numbers.size() / 2);
    }

    /**
     * Returns true if the update violates the rule.
     * <p>
     * If you encounter the second number of the rule without having encountered the first number of the rule, you're violating it.
     *
     * @param rule
     * @return true if the update violates the rule
     */
    public boolean violates(Rule rule) {
        if (!numbers.contains(rule.getX()) && !numbers.contains(rule.getY()))
            return false;
        int indexX = numbers.indexOf(rule.getX());
        int indexY = numbers.indexOf(rule.getY());
        return indexX > indexY;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

}
