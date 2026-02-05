package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.file.Interfaces.IReader;

import java.util.List;

/**
 * Класс обработчик файлов.
 * <p>
 * Класс последовательно открывает файлы из списка {@code paths},
 * читает их построчно с помощью {@link IReader} и передаёт данные
 * в {@link Filter} для фильтрации и записи.
 * </p>
 *
 * @author Alsaev Dmitry
 */
public class FileHandler {
    private final List<String> paths;
    private final IReader reader;
    private final Filter filter;

    /**
     * Конструктор класса {@code FileHandler}.
     *
     * @param reader реализация класса для чтения файлов
     * @param filter фильтр для распределения данные и сбора статистики
     * @param paths список путей к файлам
     */
    public FileHandler(IReader reader, Filter filter, List<String> paths) {
        this.reader = reader;
        this.filter = filter;
        this.paths = paths;
    }

    /**
     * Запускает цикл обработки всех файлов в списке {@code paths}.
     * <p>
     * Метод последовательно открывает каждый файл с помощью {@link  IReader}.
     * Каждая считанная строка передаётся в {@link Filter} для распределения и сбора статистики.
     * Если при работе с конкретным файлом возникает ошибка, то она выводится в поток ошибок,
     * а обработчик переходит к следующему файлу.
     * </p>
     * @return {@code true}, если хотя бы один файл был успешно открыт для чтения; <br>
     *         {@code false}, если ни один из файлов не удалось открыть для чтения.
     */
    public boolean handleFiles() {
        boolean success = false;
        for (String path : paths) {
            try {
                reader.open(path);
                success = true;

                String line;
                while ((line = reader.readLine()) != null) {
                    filter.filter(line);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                reader.close();
            }
        }

        filter.close();
        return success;
    }
}
