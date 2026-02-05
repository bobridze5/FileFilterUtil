package ctf.alsaev.file.Interfaces;

import java.io.IOException;

@FunctionalInterface
public interface IOConsumer<T> {
    void accept(T value) throws IOException;
}
