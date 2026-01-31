package ctf.alsaev.file;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter  {

    public void writeFile(String path, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {

        } catch (IOException e) {

        }
    }
}
