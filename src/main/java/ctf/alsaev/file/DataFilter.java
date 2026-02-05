package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.file.Interfaces.IOConsumer;
import ctf.alsaev.statistics.Statistics;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Класс-реализация интерфейса {@link Filter} для фильтрации данных и сбора статистики из файлов.
 * <p>
 * Выполняет парсинг входных строк по типам ({@code long}, {@code double}, {@code String})
 * и перенаправляет их в соответствующие потоки вывода.
 * </p>
 *
 * @author Alsaev Dmitry
 */
public class DataFilter implements Filter {
    private final WriterContainer writer;
    private final Statistics statistics;

    /**
     * Конструктор класса {@link DataFilter}.
     *
     * @param writer контейнер {@link WriterContainer} с {@link FileWriter} для записи в каждый отдельный поток.
     * @param statistics объект {@link Statistics} для сбора статистики.
     */
    public DataFilter(WriterContainer writer, Statistics statistics) {
        this.writer = writer;
        this.statistics = statistics;
    }

    /**
     * Фильтрует строку, определяя её тип, и записывает в соответствующий файл.
     *
     * <p>
     * Сначала удаляются лишние пробелы, если таковые имеются. Затем происходит попытка парсинга.
     * Если тип был не определён, строка записывается как есть.s
     * </p>
     *
     * @param line исходная строка для обработки.
     * @throws IOException если возникает ошибка при записи данных через {@link WriterContainer}.
     */
    @Override
    public void filter(String line) throws IOException {
        if (line == null || line.isBlank()) return;

        line = line.strip();

        if (tryParse(line, Long::parseLong, statistics::add, writer::write)) return;
        if (tryParse(line, Double::parseDouble, statistics::add, writer::write)) return;

        statistics.add(line);
        writer.write(line);
    }

    /**
     * Закрывает все открытые {@link FileWriter} в {@link WriterContainer}.
     */
    @Override
    public void close() {
        writer.close();
    }

    /**
     * Пытается преобразовать строку в заданный тип и выполнить действие по статистике и записи.
     *
     * @param <T> тип данных, в который происходит преобразование.
     * @param s исходная строка.
     * @param parser функция для преобразования строки в тип T.
     * @param statsAction действие по обновлению статистики.
     * @param writerAction действие по записи данных.
     * @return {@code true}, если парсинг прошёл успешно; <br>
     * {@code false}, если возникла ошибка {@link NumberFormatException}.
     * @throws IOException если возникла ошибка при записи в файл.
     */
    private <T> boolean tryParse(
            String s,
            Function<String, T> parser,
            Consumer<T> statsAction,
            IOConsumer<T> writerAction
    ) throws IOException {
        try {
            T value = parser.apply(s);
            statsAction.accept(value);
            writerAction.accept(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
