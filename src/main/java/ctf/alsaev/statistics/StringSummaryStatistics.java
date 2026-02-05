package ctf.alsaev.statistics;

/**
 * Класс для сбора и вычислений статистики строковых данных.
 *
 * <p>
 * Выполнен по аналогии со стандартными классами {@code SummaryStatistics},
 * данный класс собирает статистику по количеству строк,
 * находит минимальную и максимальную длину среди строк.
 * </p>
 *
 * @author Alsaev Dmitry
 */
public class StringSummaryStatistics {
    private long count;
    private long minLen = Long.MAX_VALUE;
    private long maxLen = Long.MIN_VALUE;

    /**
     * Принимает строковое значение
     *
     * <p>
     * Увеличивает счётчик и обновляет значения минимальной и максимальной длины.
     * </p>
     *
     * @param value строка
     */
    public void accept(String value) {
        count++;
        long length = value.length();
        minLen = Math.min(minLen, length);
        maxLen = Math.max(maxLen, length);
    }

    /**
     *  Возвращает общее количество обработанных строк.
     *
     * @return количество элементов.
     */
    public long getCount() {
        return count;
    }

    /**
     *  Возращает максимальную длину среди всех обработанных строк.
     *
     * @return максимальная длина.
     */
    public long getMaxLen() {
        return maxLen;
    }

    /**
     *  Возращает минимальную длину среди всех обработанных строк.
     *
     * @return минимальная длина.
     */
    public long getMinLen() {
        return minLen;
    }
}
