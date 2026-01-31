package ctf.alsaev.file;

import java.io.*;
import java.util.List;

public class FileManager {
    private List<String> paths;

    public FileManager() {

    }

    public FileManager(List<String> paths) {
        this.paths = paths;
    }

    public void process() {
        for (String path : paths) {
            FileHandler fileHandler = new FileHandler();
            fileHandler.readFile(path);

        }
    }
}
