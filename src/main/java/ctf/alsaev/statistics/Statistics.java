package ctf.alsaev.statistics;

import java.util.Map;

public interface Statistics {
    void add(double value);
    void add(String value);
    Map<String, Double> collect();
}
