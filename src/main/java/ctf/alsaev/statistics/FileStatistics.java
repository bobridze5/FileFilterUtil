package ctf.alsaev.statistics;

import java.util.DoubleSummaryStatistics;
import java.util.LongSummaryStatistics;

/**
 * Класс-реализация интерфейса {@link Statistics} для сбора статистики по файлам.
 *
 * <p>
 * В реализации используются {@link LongSummaryStatistics}, {@link DoubleSummaryStatistics}
 * и {@link StringSummaryStatistics} для сбора статистики по каждому типу данных
 * и для вычисления количества элементов, минимумов, максимумов, сумм и средних значений.
 * </p>
 *
 * @author Alsaev Dmitry
 */
public class FileStatistics implements Statistics {
    private final LongSummaryStatistics longSummaryStatistics = new LongSummaryStatistics();
    private final DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
    private final StringSummaryStatistics stringSummaryStatistics = new StringSummaryStatistics();

    /**
     * Добавляет целое число в статистику.
     *
     * @param value значение типа {@code long}.
     */
    public void add(long value) {
        longSummaryStatistics.accept(value);
    }

    /**
     * Добавляет число с плавающей точкой в статистику.
     *
     * @param value значение типа {@code double}.
     */
    public void add(double value) {
        doubleSummaryStatistics.accept(value);
    }

    /**
     * Добавляет строку в статистику.
     *
     * @param value значение типа {@code String}.
     */
    public void add(String value) {
        stringSummaryStatistics.accept(value);
    }

    /**
     * Формирует итоговый отчёт на основе накопленных данных.
     *
     * @return объект {@link StatisticsReport}, содержащий статистику по каждому типу данных.
     */
    @Override
    public StatisticsReport collect() {
        return new StatisticsReport(
                longSummaryStatistics,
                doubleSummaryStatistics,
                stringSummaryStatistics
        );
    }
}
