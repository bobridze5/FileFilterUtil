package ctf.alsaev.file;

import ctf.alsaev.cmd.Args;
import ctf.alsaev.statistics.Statistics;

import java.io.IOException;
import java.util.List;

public class FileManager {
    private final List<String> paths;
    private final FileWriter fileWriter;
    private final FileHandler fileHandler;
    private final Statistics statistics;

    public FileManager(Args args) {
        this.paths = args.getPaths();
        this.statistics = new Statistics();
        this.fileWriter = new FileWriter(args.getOutputPath(), args.getPrefixName(), args.isAppendMode());
        this.fileHandler = new FileHandler(new DataFilter(fileWriter, statistics));
    }

    public Statistics process() {
        for (String path : paths) {
            fileHandler.handle(path);
        }

        closeWriter();

        return statistics;
    }

    private void closeWriter() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
