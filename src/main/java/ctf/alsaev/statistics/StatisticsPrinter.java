package ctf.alsaev.statistics;

/**
 * Утилитарный класс для вывода статистических данных в консоль
 * <p>
 * Поддерживает два режима отображения:
 * <ul>
 *  <li>Краткий - только количество элементов по каждому типу данных</li>
 *  <li>Полный - расширенные показатели (min, max, sum, avg) для чисел и показатели (minLen, maxLen) для строк</li>
 * </ul>
 * </p>
 * @author Alsaev Dmitry
 */
public class StatisticsPrinter {

    /**
     * Выводит статистику в консоль в зависимости от параметров {@code showFull} и {@code showShort}.
     *
     * @param report объект {@link StatisticsReport} с накопленными данными.
     * @param showFull флаг для вывода полной статистики.
     * @param showShort флаг для вывода краткой статистики.
     */
    public static void print(StatisticsReport report, boolean showFull, boolean showShort) {
        if (showFull) {
            printFullStatistic(report);
        } else if (showShort) {
            printShortStatistics(report);
        }
    }

    /**
     * Выводит в консоль полную статистику по каждому типу данных.
     *
     * @param report объект {@link StatisticsReport} с накопленными данными.
     */
    private static void printFullStatistic(StatisticsReport report) {
        System.out.println("Full Statistics\n");

        if (report.longSummaryStatistics().getCount() > 0) {
            printHeader("Integers");
            var stats = report.longSummaryStatistics();
            System.out.printf("Count:  \t %s\n", stats.getCount());
            System.out.printf("Min:    \t %s\n", stats.getMin());
            System.out.printf("Max:    \t %s\n", stats.getMax());
            System.out.printf("Sum:    \t %s\n", stats.getSum());
            System.out.printf("Average:\t %s\n", stats.getAverage());
            printFooter();
        }

        if (report.doubleSummaryStatistics().getCount() > 0) {
            printHeader("Floats");
            var stats = report.doubleSummaryStatistics();
            System.out.printf("Count:  \t %s\n", stats.getCount());
            System.out.printf("Min:    \t %s\n", stats.getMin());
            System.out.printf("Max:    \t %s\n", stats.getMax());
            System.out.printf("Sum:    \t %s\n", stats.getSum());
            System.out.printf("Average:\t %s\n", stats.getAverage());
            printFooter();
        }

        if (report.stringSummaryStatistics().getCount() > 0) {
            printHeader("Strings");
            var stats = report.stringSummaryStatistics();
            System.out.printf("Count:     \t %s\n", stats.getCount());
            System.out.printf("Min length:\t %s\n", stats.getMinLen());
            System.out.printf("Max length:\t %s\n", stats.getMaxLen());
            printFooter();
        }
    }

    /**
     * Выводит в консоль краткую статистику по каждому типу данных.
     *
     * @param report объект {@link StatisticsReport} с накопленными данными.
     */
    private static void printShortStatistics(StatisticsReport report) {
        System.out.println("Short Statistics\n");

        if (report.longSummaryStatistics().getCount() > 0) {
            printHeader("Integers");
            var stats = report.longSummaryStatistics();
            System.out.printf("Count:  \t %s\n", stats.getCount());
            printFooter();
        }

        if (report.doubleSummaryStatistics().getCount() > 0) {
            printHeader("Floats");
            var stats = report.doubleSummaryStatistics();
            System.out.printf("Count:  \t %s\n", stats.getCount());
            printFooter();
        }

        if (report.stringSummaryStatistics().getCount() > 0) {
            printHeader("Strings");
            var stats = report.stringSummaryStatistics();
            System.out.printf("Count:  \t %s\n", stats.getCount());
            printFooter();
        }
    }

    /**
     * Выводит в консоль оформленный заголовок.
     *
     * @param title название заголовка.
     */
    private static void printHeader(String title) {
        System.out.println("-".repeat(50));
        System.out.println(title);
        System.out.println("-".repeat(50));
    }

    /**
     * Выводит в консоль разделитель между блоками.
     */
    private static void printFooter() {
        System.out.println("-".repeat(50));
        System.out.println();
    }
}
