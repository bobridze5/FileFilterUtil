package ctf.alsaev.file.Interfaces;

public interface IReader {
    void open(String path);
    String readLine();
    void close();
}
