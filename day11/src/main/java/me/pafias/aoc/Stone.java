package me.pafias.aoc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stone {

    private String number;

    public Stone(String number) {
        this.number = number.trim();
    }

    public long getNumberAsInt() {
        return Long.parseLong(number);
    }

    public boolean hasEvenLength() {
        return number.length() % 2 == 0;
    }

    public long[] split() {
        long[] result = new long[2];
        String s1 = number.substring(0, number.length() / 2);
        String s2 = number.substring(number.length() / 2);
        result[0] = Long.parseLong(s1);
        result[1] = Long.parseLong(s2);
        return result;
    }

}
