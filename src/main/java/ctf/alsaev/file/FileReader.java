package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс-реализация интерфейса {@link IReader} для чтения файла.
 *
 * @author Alsaev Dmitry
 */
public class FileReader implements IReader {
    private BufferedReader reader;

    /**
     * Открывает файл для чтения с проверкой его состояния.
     *
     * @param filePath путь до файла
     * @throws IOException если путь является директорией или файла не существует
     */
    public void open(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new FileNotFoundException("Файл не найден: " + path.toAbsolutePath());
        }

        if (!Files.isRegularFile(path)) {
            throw new IOException("Указанный путь не является файлом");
        }

        reader = Files.newBufferedReader(path);
    }

    /**
     * Считывает строчку из файла
     *
     * @return строка из файла или {@code null}, если достигнут конец файла.
     * @throws IOException если возникла ошибка при чтении данных.
     */
    @Override
    public String readLine() throws IOException {
        if (reader == null) throw new IllegalStateException("Файл не открыт!");
        return reader.readLine();
    }

    /**
     * Закрывает текущий поток для чтения.
     */
    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("Не удалось закрыть reader: " + e.getMessage());
            }
        }
    }
}
