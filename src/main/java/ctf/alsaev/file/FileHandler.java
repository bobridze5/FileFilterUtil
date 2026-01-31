package ctf.alsaev.file;

import java.io.*;

public class FileHandler {

    public void readFile(String path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {

            }
        } catch (IOException e) {

        }
    }

    public void writeFile(String path, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

        } catch (IOException e) {

        }
    }
}
