package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.file.Interfaces.IReader;

import java.util.List;

public class FileHandler {
    private final List<String> paths;
    private final IReader reader;
    private final Filter filter;

    public FileHandler(IReader reader, Filter filter, List<String> paths) {
        this.reader = reader;
        this.filter = filter;
        this.paths = paths;
    }

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
