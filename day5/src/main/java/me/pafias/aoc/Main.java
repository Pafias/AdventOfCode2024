package me.pafias.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int part1(List<String> input) {
        List<Rule> rules = new ArrayList<>();
        List<Update> updates = new ArrayList<>();

        boolean b = false;
        for (String s : input) {
            if (s.isEmpty()) {
                b = true;
                continue;
            }
            if (b)
                updates.add(Update.fromInput(s));
            else
                rules.add(Rule.fromInput(s));
        }

        List<Update> correct = new ArrayList<>();

        for (Update update : updates) {
            List<Rule> violated = new ArrayList<>();
            for (Rule rule : rules) {
                if (update.violates(rule)) {
                    violated.add(rule);
                }
            }
            if (violated.isEmpty())
                correct.add(update);
        }

        int sum = 0;
        for (Update update : correct) {
            sum += update.getMiddleNumber();
        }

        return sum;
    }

    public static int part2(List<String> input) {
        return -1;
    }

    public static List<String> readFileLines(String file) throws Exception {
        return Files.readAllLines(Path.of(Main.class.getResource(file).toURI()));
    }

}