package ctf.alsaev.file.Interfaces;

import java.io.IOException;

/**
 * Интерфейс для чтения текстовых данных.
 *
 * @author Alsaev Dmitry
 */
public interface IReader {
    /**
     * Открывает для чтения файл.
     *
     * @param path путь к файлу
     * @throws IOException если возникла ошибка при открытии файла
     */
    void open(String path) throws IOException;

    /**
     * Читает и возвращает строку.
     * @return прочитанную строку
     * @throws IOException если возникла ошибка при чтении файла
     */
    String readLine() throws IOException;

    /**
     * Закрывает поток ввода.
     */
    void close();
}
