package ctf.alsaev.file;

import java.io.IOException;

@FunctionalInterface
public interface Filter {
    void filter(String line) throws IOException;
}
