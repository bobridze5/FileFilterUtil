package ctf.alsaev.file;

import ctf.alsaev.statistics.Statistics;

import java.io.IOException;

public class DataFilter implements Filter {
    private final FileWriter writer;
    private final Statistics statistics;

    public DataFilter(FileWriter writer, Statistics statistics) {
        this.writer = writer;
        this.statistics = statistics;
    }

    @Override
    public void filter(String line) throws IOException {
        if (line == null || line.isBlank()) return;

        line = line.strip();
        try {
            long value = Long.parseLong(line);
            statistics.add(value);
            writer.write(value);
        } catch (NumberFormatException e1) {
            try {
                double value = Double.parseDouble(line);
                statistics.add(value);
                writer.write(value);
            } catch (NumberFormatException e2) {
                statistics.add(line);
                writer.write(line);
            }
        }

    }

}
