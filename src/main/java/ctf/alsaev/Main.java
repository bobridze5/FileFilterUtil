package ctf.alsaev;

import com.beust.jcommander.JCommander;
import ctf.alsaev.cmd.Args;
import ctf.alsaev.file.DataFilter;
import ctf.alsaev.file.FileHandler;
import ctf.alsaev.file.FileReader;
import ctf.alsaev.file.Interfaces.Filter;
import ctf.alsaev.file.Interfaces.IReader;
import ctf.alsaev.file.WriterContainer;
import ctf.alsaev.statistics.FileStatistics;
import ctf.alsaev.statistics.Statistics;
import ctf.alsaev.statistics.StatisticsPrinter;

/**
 * Главный класс приложения.
 * <p>
 * Выполняет инициализацию парсера аргументов, настраивает компоненты для ввода/вывода,
 * запускает процесс фильтрации и выводит финальную статистика
 * </p>
 *
 * @author Alsaev Dmitry
 */
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
        FileHandler fileHandler = new FileHandler(reader, filter, pArgs.getPaths());
        if(fileHandler.handleFiles()) {
            StatisticsPrinter.print(statistics.collect(), pArgs.isFullStatsMode(), pArgs.isShortStatsMode());
        }
    }
}
