package ctf.alsaev.file;

@FunctionalInterface
public interface Filter {
    void filter(String line);
}
