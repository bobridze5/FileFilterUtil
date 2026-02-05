package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.file.Interfaces.IWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * Класс-реализация интерфейса {@link IWriter} для записи текстовых данных в файл.
 *
 * <p>
 * Поддерживает автоматическое создание родительских директорий и ленивую инициализацию потока записи
 * </p>
 *
 * @author Alsaev Dmitry
 */
public class FileWriter implements IWriter {
    private final Path path;
    private final boolean append;
    private BufferedWriter writer;

    /**
     * Конструктор класса {@link FileWriter}
     * @param path путь к директории вывода.
     * @param prefix префикс для имени выходного файла.
     * @param fileName название выходного файла
     * @param append режим записи: {@code true} - дозаписать в конец файла,
     * {@code false} - перезаписать существующий файл либо создать, если такого нет.
     */
    public FileWriter(String path, String prefix, String fileName, boolean append) {
        this.path = Paths.get(path, prefix + fileName);
        this.append = append;
    }

    /**
     * Записывает строку в файл.
     * <p>
     * При первом вызове проверяет наличие директории и открывает поток для записи.
     * После записи добавляет перевод строки.
     * </p>
     *
     * @param line строка для записи.
     * @throws IOException если невозможно создать директории или возникает ошибка доступа к файлу.
     */
    @Override
    public void write(String line) throws IOException {
        if (writer == null) {
            createDirectoryIfNotExists(path);
            writer = createWriter(path, append);
        }
        writer.write(line);
        writer.newLine();
    }

    /**
     * Закрывает поток записи
     */
    @Override
    public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Не удалось закрыть writer: " + e.getMessage());
            }
        }
    }

    /**
     * Создаёт цепочку родительских директорий, если они отсутствуют.
     *
     * @param path полный путь к файлу.
     * @throws IOException если создание директорий невозможно.
     */
    private void createDirectoryIfNotExists(Path path) throws IOException {
        Path parentDirectory = path.getParent();
        if (parentDirectory != null) {
            Files.createDirectories(parentDirectory);
        }
    }

    /**
     * Создаёт новый поток для записи на основе {@link BufferedWriter}.
     *
     * @param path путь к файлу.
     * @param append режим дозаписи.
     * @return объект {@link BufferedWriter}.
     * @throws IOException если файл не может быть открыт.
     */
    private BufferedWriter createWriter(Path path, boolean append) throws IOException {
        return Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, append ?
                StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
    }
}
