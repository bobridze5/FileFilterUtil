package ctf.alsaev.file;

import java.util.ArrayList;
import java.util.List;

public class DataFilter {
    private List<Long> integers = new ArrayList<>();
    private List<Double> doubles = new ArrayList<>();
    private List<String> strings = new ArrayList<>();

    public void filter(String line) {
        if (line == null || line.isBlank()) return;

        for (String word : line.split(" ")) {
            try {
                long value = Long.parseLong(word);
                integers.add(value);
            } catch (NumberFormatException e1) {
                try {
                    double value = Double.parseDouble(word);
                    doubles.add(value);
                } catch (NumberFormatException e2) {
                    strings.add(word);
                }
            }
        }
    }

    public List<Double> getDoubles() {
        return new ArrayList<>(doubles);
    }

    public List<Long> getIntegers() {
        return new ArrayList<>(integers);
    }

    public List<String> getStrings() {
        return new ArrayList<>(strings);
    }
}
