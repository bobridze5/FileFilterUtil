package ctf.alsaev.statistics;

public interface Statistics {
    void add(long value);
    void add(double value);
    void add(String value);
    StatisticsReport collect();
}
