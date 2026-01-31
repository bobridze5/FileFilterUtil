package ctf.alsaev.file;

import ctf.alsaev.statistics.Statistics;

public class DataFilter implements Filter {
    private final Statistics statistics = new Statistics();

    public void filter(String line) {
        if (line == null || line.isBlank()) return;

        try {
            long value = Long.parseLong(line);
            statistics.add((double) value);
        } catch (NumberFormatException e1) {
            try {
                double value = Double.parseDouble(line);
                statistics.add(value);
            } catch (NumberFormatException e2) {
                statistics.add(line);
            }
        }

    }

    public Statistics getStatistics() {
        return statistics;
    }
}
