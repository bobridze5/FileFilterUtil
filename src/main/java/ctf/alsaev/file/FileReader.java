package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader implements IReader {
    private BufferedReader reader;

    public void open(String filePath) {
        try {
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                throw new FileNotFoundException("Файл не найден: " + path.toAbsolutePath());
            }

            if (!Files.isRegularFile(path)) {
                throw new IOException("Указанный путь не является файлом");
            }

            reader = Files.newBufferedReader(path);

        } catch (InvalidPathException e) {
            throw new RuntimeException("Некорректный путь к файлу: " + filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка доступа к файлу: " + e.getMessage());
        }
    }

    @Override
    public String readLine() {
        if (reader == null) throw new IllegalStateException("Файл не открыт!");
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + reader);
        }
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ignored) {
            }
        }
    }
}
