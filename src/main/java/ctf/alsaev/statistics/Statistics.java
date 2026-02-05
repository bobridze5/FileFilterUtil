package ctf.alsaev.statistics;

/**
 * Интерфейс для сбора и обработки статистики.
 *
 * @author Alsaev Dmitry
 */
public interface Statistics {
    /**
     * Добавляет целое число.
     *
     * @param value значение типа {@code long}.
     */
    void add(long value);
    /**
     * Добавляет число с плавающей точкой.
     *
     * @param value значение типа {@code double}.
     */
    void add(double value);

    /**
     * Добавляет строку.
     *
     * @param value значение типа {@code String}.
     */
    void add(String value);

    /**
     * Формирует и возвращает итоговый отчёт на основе накопленных данных.
     *
     * @return объект {@link StatisticsReport}, содержащий результаты вычислений.
     */
    StatisticsReport collect();
}
