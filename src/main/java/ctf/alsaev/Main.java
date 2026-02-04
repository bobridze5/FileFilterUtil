package ctf.alsaev;

import com.beust.jcommander.JCommander;
import ctf.alsaev.cmd.Args;
import ctf.alsaev.file.DataFilter;
import ctf.alsaev.file.FileManager;
import ctf.alsaev.file.FileReader;
import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.file.Interfaces.IReader;
import ctf.alsaev.file.WriterContainer;
import ctf.alsaev.statistics.FileStatistics;
import ctf.alsaev.statistics.Statistics;
import ctf.alsaev.statistics.StatisticsPrinter;

public class Main {
    public static void main(String[] args) {
        Args pArgs = new Args();
        JCommander jc = JCommander.newBuilder()
                .addObject(pArgs)
                .build();

        jc.parse(args);


        if (pArgs.isHelp()) {
            jc.usage();
        }

        WriterContainer container = new WriterContainer(
                pArgs.getOutputPath(),
                pArgs.getPrefixName(),
                pArgs.isAppendMode()
        );

        IReader reader = new FileReader();
        Statistics statistics = new FileStatistics();
        Filter filter = new DataFilter(container, statistics);
        FileManager fileManager = new FileManager(reader, filter, pArgs.getPaths());
        fileManager.run();
        StatisticsPrinter.print(statistics);
    }
}
