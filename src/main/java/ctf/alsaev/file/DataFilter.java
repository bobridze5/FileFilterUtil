package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.statistics.Statistics;

import java.util.function.Consumer;
import java.util.function.Function;

public class DataFilter implements Filter {
    private final WriterContainer writer;
    private final Statistics statistics;

    public DataFilter(WriterContainer writer, Statistics statistics) {
        this.writer = writer;
        this.statistics = statistics;
    }

    @Override
    public void filter(String line) {
        if (line == null || line.isBlank()) return;

        line = line.strip();

        if (tryParse(line, Long::parseLong, statistics::add, writer::write)) return;
        if (tryParse(line, Double::parseDouble, statistics::add, writer::write)) return;

        statistics.add(line);
        writer.write(line);
    }

    @Override
    public void close() {
        writer.close();
    }

    private <T> boolean tryParse(
            String s,
            Function<String, T> parser,
            Consumer<T> statsAction,
            Consumer<T> writerAction
    ) {
        try {
            T value = parser.apply(s);
            statsAction.accept(value);
            writerAction.accept(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
