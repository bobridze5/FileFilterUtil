package ctf.alsaev.file.Interfaces;

import java.io.IOException;

public interface Filter {
    void filter(String line) throws IOException;
    void close();
}
