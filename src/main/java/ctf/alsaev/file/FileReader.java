package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IReader;

import java.io.*;

public class FileReader implements IReader {
    private final String path;
    private BufferedReader reader;

    public FileReader(String path){
         this.path = path;
    }

    @Override
    public String readLine() {
        try {
            if (reader == null) {
                File file = new File(path);
                reader = new BufferedReader(new java.io.FileReader(file));
            }
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ignored){}
        }
    }
}
