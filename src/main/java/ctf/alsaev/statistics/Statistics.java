package ctf.alsaev.statistics;

import java.util.Map;

@FunctionalInterface
public interface Statistics {
    Map<String, Double> collect();
}
