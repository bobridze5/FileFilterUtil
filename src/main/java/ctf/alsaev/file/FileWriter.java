package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IWriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class FileWriter implements IWriter {
    private final Path path;
    private final boolean append;
    private BufferedWriter writer;

    public FileWriter(String path, String prefix, String fileName, boolean append) {
        this.path = Paths.get(path, prefix + fileName);
        this.append = append;
    }

    @Override
    public void write(String line) throws IOException {
        if (writer == null) {
            createDirectoryIfNotExists(path);
            writer = createWriter(path, append);
        }
        writer.write(line);
        writer.newLine();
    }

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

    private void createDirectoryIfNotExists(Path path) throws IOException {
        Path parentDirectory = path.getParent();
        if (parentDirectory != null) {
            Files.createDirectories(parentDirectory);
        }
    }

    private BufferedWriter createWriter(Path path, boolean append) throws IOException {
        return Files.newBufferedWriter(path, StandardOpenOption.CREATE, append ?
                StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
    }
}
