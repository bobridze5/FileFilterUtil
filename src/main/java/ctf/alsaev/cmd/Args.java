package ctf.alsaev.cmd;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Args {
    @Parameter
    List<String> paths = new ArrayList<>();

    @Parameter(
            names = {"-o", "--output"},
            description = "Указать путь для результатов",
            arity = 1
    )
    private String outputPath;

    @Parameter(
            names = {"-p", "--prefix"},
            description = "Добавить префикс для имён выходных файлов",
            arity = 1
    )
    private String prefixName;

    @Parameter(
            names = {"-a", "--append"},
            description = "Дополнить содержимое существующих файлов"
    )
    private boolean isAppendMode = false;

    @Parameter(
            names = {"-s", "--short"},
            description = "Вывести краткую статистику по типам данных"
    )
    private boolean isShortStatsMode = false;

    @Parameter(
            names = {"-f", "--full"},
            description = "Вывести полную статистику по типам данных"
    )
    private boolean isFullStatsMode = false;

    @Parameter(
            names = {"-h", "--help"},
            help = true,
            description = "Показать справку"
    )
    private boolean help;


    public boolean isHelp() {
        return help;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public List<String> getPaths() {
        return new ArrayList<>(paths);
    }
}
