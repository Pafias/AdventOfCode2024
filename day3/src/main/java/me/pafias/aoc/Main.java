package me.pafias.aoc;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int part1(String corruptedMemoryString) {
        List<String> muls = new ArrayList<>();
        for (int i = 0; i < corruptedMemoryString.length(); i++) {
            try {
                int nextClosingBracket = corruptedMemoryString.indexOf(")", i);
                String chunk = corruptedMemoryString.substring(i, nextClosingBracket + 1);
                if (chunk.matches("mul\\(\\d+,\\d+\\)")) // RegEx 😎
                    muls.add(chunk);
            } catch (StringIndexOutOfBoundsException ex) {
                break;
            }
        }

        int sum = 0;

        for (String mul : muls) {
            try {
                // Doing this with reflection because why not
                Method method = Main.class.getDeclaredMethod(mul.split("\\(")[0], int.class, int.class);
                String trimmed = mul.substring(4, mul.length() - 1);
                Integer[] args = Arrays.stream(trimmed.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
                int result = (int) method.invoke(null, args);
                sum += result;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return sum;
    }

    private static int mul(int a, int b) {
        return a * b;
    }

    public static int part2(String corruptedMemoryString) {
        return -1;
    }

    public static String readFileLines(String file) throws Exception {
        return String.join("", Files.readAllLines(Path.of(Main.class.getResource(file).toURI())));
    }

}