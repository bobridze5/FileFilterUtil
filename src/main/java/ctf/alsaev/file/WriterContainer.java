package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IWriter;

import java.io.IOException;

/**
 * Класс-контейнер, который содержит три потока {@link IWriter} для вывода разных типов данных.
 *
 * <p>
 * Распределяет данные по соответствующим файлам: {@code integers.txt}, {@code floats.txt} и {@code strings.txt}.
 * </p>
 *
 * @author Alsaev Dmitry
 */
public class WriterContainer {
    private final IWriter intWriter;
    private final IWriter floatWriter;
    private final IWriter stringWriter;

    /**
     * Конструктор класса {@link WriterContainer}.
     *
     * <p>
     * Производит инициализацию трёх выходных потоков.
     * </p>
     *
     * @param path путь до выходного файла.
     * @param prefix префикс для выходного файла.
     * @param append режим дозаписи.
     */
    public WriterContainer(String path, String prefix, boolean append) {
        this.intWriter = new FileWriter(path, prefix, "integers.txt", append);
        this.floatWriter = new FileWriter(path, prefix, "floats.txt", append);
        this.stringWriter = new FileWriter(path, prefix, "strings.txt", append);
    }

    /**
     * Записывает целое число в файл {@code integers.txt}.
     *
     * @param value значение типа {@code long}.
     * @throws IOException если возникла ошибка при записи.
     */
    public void write(long value) throws IOException {
        intWriter.write(String.valueOf(value));
    }

    /**
     * Записывает число с плавающей точкой в файл {@code floats.txt}.
     *
     * @param value значение типа {@code double}.
     * @throws IOException если возникла ошибка при записи.
     */
    public void write(double value) throws IOException {
        floatWriter.write(String.valueOf(value));
    }

    /**
     * Записывает строку в файл {@code strings.txt}.
     *
     * @param value значение типа {@code String}.
     * @throws IOException если возникла ошибка при записи.
     */
    public void write(String value) throws IOException {
        stringWriter.write(value);
    }

    /**
     * Закрывает все внутренние потоки записи.
     */
    public void close() {
        intWriter.close();
        floatWriter.close();
        stringWriter.close();
    }
}
