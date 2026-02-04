package ctf.alsaev.statistics;

import java.util.DoubleSummaryStatistics;
import java.util.LongSummaryStatistics;

public record StatisticsReport(
        LongSummaryStatistics longSummaryStatistics,
        DoubleSummaryStatistics doubleSummaryStatistics,
        StringSummaryStatistics stringSummaryStatistics
) {
}
