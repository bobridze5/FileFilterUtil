package ctf.alsaev.statistics;

import java.util.DoubleSummaryStatistics;
import java.util.LongSummaryStatistics;

public class FileStatistics implements Statistics {
    LongSummaryStatistics longSummaryStatistics = new LongSummaryStatistics();
    DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
    StringSummaryStatistics stringSummaryStatistics = new StringSummaryStatistics();

    public void add(long value) {
        longSummaryStatistics.accept(value);
    }

    public void add(double value) {
        doubleSummaryStatistics.accept(value);
    }

    public void add(String value) {
        stringSummaryStatistics.accept(value);
    }

    @Override
    public StatisticsReport collect() {
        return new StatisticsReport(
                longSummaryStatistics,
                doubleSummaryStatistics,
                stringSummaryStatistics
        );
    }
}
