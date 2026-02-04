package ctf.alsaev.file;

import java.io.*;

public class FileHandler {
    private final Filter filter;

    public FileHandler(Filter filter) {
        this.filter = filter;
    }

    public void handle(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                filter.filter(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
