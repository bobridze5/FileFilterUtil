package ctf.alsaev.statistics;

import java.util.DoubleSummaryStatistics;
import java.util.LongSummaryStatistics;

/**
 * Record, содержащий статистические данные.
 *
 * @param longSummaryStatistics статистика по целым числам.
 * @param doubleSummaryStatistics статистика по числам с плавающей точкой.
 * @param stringSummaryStatistics статистика по строкам.
 */
public record StatisticsReport(
        LongSummaryStatistics longSummaryStatistics,
        DoubleSummaryStatistics doubleSummaryStatistics,
        StringSummaryStatistics stringSummaryStatistics
) {
}
