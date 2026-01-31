package ctf.alsaev.file;

import ctf.alsaev.statistics.Statistics;
import ctf.alsaev.statistics.StatisticsPrinter;

import java.util.List;

public class FileManager {
    private final List<String> paths;
    private final DataFilter dataFilter = new DataFilter();

    public FileManager(List<String> paths) {
        this.paths = paths;
    }

    public void process() {
        FileReader fileReader = new FileReader(dataFilter);

        for (String path : paths) {
            fileReader.readFile(path);
        }

        Statistics statistics = dataFilter.getStatistics();
        StatisticsPrinter.print(statistics);

        FileWriter fileWriter = new FileWriter();
    }
}
