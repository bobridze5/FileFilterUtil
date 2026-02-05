package ctf.alsaev.cmd;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, отвечающий за конфигурацию аргументов командной строки.
 *
 * <p>
 * Использует библиотеку {@link com.beust.jcommander.JCommander} для автоматического
 * сопоставления флагов командной строки с полями класса.
 * </p>
 *
 * @author Alsaev Dmitry
 */
public class Args {
    @Parameter(description = "Список входных файлов")
    List<String> paths = new ArrayList<>();

    @Parameter(
            names = {"-o", "--output"},
            description = "Указать путь для результатов",
            arity = 1
    )
    private String outputPath = "";

    @Parameter(
            names = {"-p", "--prefix"},
            description = "Добавить префикс для имён выходных файлов",
            arity = 1
    )
    private String prefixName = "";

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


    /**
     * Проверяет, был ли запрошен вывод справки
     * @return {@code true}, если передан флаг -h или --help
     */
    public boolean isHelp() {
        return help;
    }

    /**
     * @return Путь к директории вывода.
     */
    public String getOutputPath() {
        return outputPath;
    }

    /**
     * @return префикс имён файлов.
     */
    public String getPrefixName() {
        return prefixName;
    }

    /**
     * @return {@code true}, если выбран режим дозаписи.
     */
    public boolean isAppendMode() {
        return isAppendMode;
    }

    /**
     * @return {@code true}, если выбран режим краткой статистики.
     */
    public boolean isShortStatsMode() {
        return isShortStatsMode;
    }

    /**
     * @return {@code true}, если выбран режим полной статистики.
     */
    public boolean isFullStatsMode() {
        return isFullStatsMode;
    }

    /**
     * Возвращает неизменяемую копию списка путей к входным файлам.
     * @return список строк путей.
     */
    public List<String> getPaths() {
        return new ArrayList<>(paths);
    }
}
