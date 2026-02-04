package ctf.alsaev.file;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    private final String path;
    private final String prefix;
    private final boolean append;

    private BufferedWriter intWriter;
    private BufferedWriter floatWriter;
    private BufferedWriter stringWriter;

    public FileWriter(String path, String prefix, boolean append) {
        this.path = path;
        this.prefix = prefix;
        this.append = append;
    }

    public void write(long value) throws IOException {
        if (intWriter == null) intWriter = createWriter("integers.txt");
        intWriter.write(String.valueOf(value));
        intWriter.newLine();
    }

    public void write(double value) throws IOException {
        if (floatWriter == null) floatWriter = createWriter("floats.txt");
        floatWriter.write(String.valueOf(value));
        floatWriter.newLine();
    }

    public void write(String value) throws IOException {
        if (stringWriter == null) stringWriter = createWriter("strings.txt");
        stringWriter.write(value);
        stringWriter.newLine();
    }

    private BufferedWriter createWriter(String fileName) throws IOException {
        String fullPath = path + ((path.isEmpty()) ? "" : "/") + prefix + fileName;
        return new BufferedWriter(new java.io.FileWriter(fullPath, append));
    }

    public void close() throws IOException {
        if (intWriter != null) intWriter.close();
        if (floatWriter != null) floatWriter.close();
        if (stringWriter != null) stringWriter.close();
    }
}
