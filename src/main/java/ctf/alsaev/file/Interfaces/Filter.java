package ctf.alsaev.file.Interfaces;

import java.io.IOException;

/**
 * Интерфейс для фильтрации данных.
 *
 * @author Alsaev Dmitry
 */
public interface Filter {
    /**
     * Обрабатывает одну строку данных.
     * Фильтрует данные на основе реализации.
     *
     * @param line строка для фильтрации
     * @throws IOException если в процессе возникла ошибка ввода/вывода.
     */
    void filter(String line) throws IOException;

    /**
     * Завершает процесс фильтрации.
     */
    void close();
}
