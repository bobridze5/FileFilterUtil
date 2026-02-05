package ctf.alsaev.file.Interfaces;

import java.io.IOException;

public interface IReader {
    void open(String path) throws IOException;
    String readLine() throws IOException;
    void close();
}
