package ctf.alsaev.file.Interfaces;

import java.io.IOException;

public interface IWriter {
    void write(String line) throws IOException;
    void close();
}
