package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileWriter implements IWriter {
    private final String fullPath;
    private final boolean append;
    private BufferedWriter writer;

    public FileWriter(String path, String prefix, String fileName, boolean append){
        this.fullPath = Paths.get(path, prefix + fileName).toString();
        this.append = append;
    }

    @Override
    public void write(String line) {
        try {
            if (writer == null) {
                File file = new File(fullPath);
                writer = new BufferedWriter(new java.io.FileWriter(file, append));
            }
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
