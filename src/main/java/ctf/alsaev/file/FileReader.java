package ctf.alsaev.file;

import java.io.*;

public class FileReader {
    private final Filter filter;

    public FileReader(Filter filter) {
        this.filter = filter;
    }

    public void readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                filter.filter(line);
            }
        } catch (IOException e) {

        }
    }
}
