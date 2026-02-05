package ctf.alsaev.file.Interfaces;

import java.io.IOException;

/**
 * Интерфейс для записи текстовых данных.
 *
 * @author Alsaev Dmitry
 */
public interface IWriter {
    /**
     * Записывает строку.
     * @param line строка для записи.
     * @throws IOException если возникла ошибка при записи.
     */
    void write(String line) throws IOException;

    /**
     * Закрывает поток для записи.
     */
    void close();
}
