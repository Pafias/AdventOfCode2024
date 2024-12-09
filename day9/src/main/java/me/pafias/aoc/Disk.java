package me.pafias.aoc;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Disk {

    private final List<Block> layout = new LinkedList<>();

    public Disk() {
    }

    public int getChecksum() {
        int sum = 0;
        for (Block block : layout) {
            if (block instanceof File file) {
                sum += layout.indexOf(file) * file.getId();
            }
        }
        return sum;
    }

    public File getLastFile() {
        LinkedList<Block> reversed = new LinkedList<>(layout);
        Collections.reverse(reversed);
        return reversed.stream()
                .filter(block -> block instanceof File)
                .map(block -> (File) block)
                .findFirst().orElse(null);
    }

    public void defrag() {
        while (isFragmented()) {
            for (Block block : layout) {
                if (block instanceof FreeSpace freeSpace) {
                    int freeSpaceIndex = layout.indexOf(freeSpace);
                    File lastFile = getLastFile();
                    int lastFileIndex = layout.indexOf(lastFile);
                    if (lastFileIndex > freeSpaceIndex) { // Although I'm a little clueless, this if statement is needed so that the application doesn't hang
                        layout.set(freeSpaceIndex, lastFile);
                        layout.set(lastFileIndex, freeSpace);
                    }
                }
            }
        }
    }

    public boolean isFragmented() {
        FreeSpace firstFreeSpace = layout.stream()
                .filter(block -> block instanceof FreeSpace)
                .map(block -> (FreeSpace) block)
                .findFirst().orElse(null);
        int firstFreeSpaceIndex = layout.indexOf(firstFreeSpace);
        for (int i = firstFreeSpaceIndex; i < layout.size(); i++) {
            if (layout.get(i) instanceof File) {
                return true;
            }
        }
        return false;
    }

    public static Disk fromMapString(String map) {
        Disk disk = new Disk();
        int id = 0;
        boolean file = true;
        for (int i = 0; i < map.length(); i++) {
            int size = Integer.parseInt(String.valueOf(map.charAt(i)));
            for (int j = 0; j < size; j++) {
                if (file) {
                    disk.getLayout().add(new File(id));
                } else
                    disk.getLayout().add(new FreeSpace());
            }
            if (file)
                id++;
            file = !file;
        }
        return disk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : layout) {
            sb.append(block);
        }
        return sb.toString();
    }
}
