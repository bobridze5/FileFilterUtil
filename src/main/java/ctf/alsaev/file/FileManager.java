package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.file.Interfaces.IReader;

import java.util.List;

public class FileManager {
    private final List<String> paths;
    private final IReader reader;
    private final Filter filter;

    public FileManager(IReader reader, Filter filter, List<String> paths) {
        this.reader = reader;
        this.filter = filter;
        this.paths = paths;
    }

    public void handleFiles() {
        for (String path : paths) {
            try {
                reader.open(path);

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
    }
}
