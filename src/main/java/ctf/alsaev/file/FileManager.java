package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IReader;
import ctf.alsaev.file.Interfaces.IWriter;
import ctf.alsaev.statistics.Statistics;

import java.util.List;

public class FileManager {
    private final List<String> paths = null;

    private final IReader reader;
    private final IWriter writer;
    private final Statistics statistics;

    public FileManager(IReader reader, IWriter writer, Statistics statistics){
        this.statistics = statistics;
        this.writer = writer;
        this.reader = reader;
    }
}
