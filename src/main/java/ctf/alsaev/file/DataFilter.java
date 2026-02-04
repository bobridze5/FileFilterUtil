package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.statistics.fileStatistics;

import java.io.IOException;

@Deprecated
public class DataFilter implements Filter {
    private final FileWriter writer;
    private final fileStatistics fileStatistics;

    public DataFilter(FileWriter writer, fileStatistics fileStatistics) {
        this.writer = writer;
        this.fileStatistics = fileStatistics;
    }

    @Override
    public void filter(String line) throws IOException {
        if (line == null || line.isBlank()) return;

        line = line.strip();
        try {
            long value = Long.parseLong(line);
            fileStatistics.add(value);
            writer.write(value);
        } catch (NumberFormatException e1) {
            try {
                double value = Double.parseDouble(line);
                fileStatistics.add(value);
                writer.write(value);
            } catch (NumberFormatException e2) {
                fileStatistics.add(line);
                writer.write(line);
            }
        }

    }

}
