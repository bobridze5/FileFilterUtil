package ctf.alsaev.statistics;

public class StatisticsPrinter {
//    public static void print(Statistics fileStatistics) {
//        System.out.println("*".repeat(10) + " Статистика " + "*".repeat(10));
//        System.out.printf("Кол-во чисел:\t%d\n", fileStatistics.getCountNumbers());
//        System.out.printf("Кол-во строк:\t%d\n", fileStatistics.getCountStrings());
//        System.out.printf("Среднее:     \t%s\n", BigDecimal.valueOf(fileStatistics.getAverage()).toPlainString());
//        System.out.printf("Сумма:       \t%s\n", BigDecimal.valueOf(fileStatistics.getSum()).toPlainString());
//        System.out.printf("Максимум:    \t%s\n", BigDecimal.valueOf(fileStatistics.getMax()).toPlainString());
//        System.out.printf("Минимум:     \t%s\n", BigDecimal.valueOf(fileStatistics.getMin()).toPlainString());
//        System.out.printf("Длина мин:   \t%d\n", fileStatistics.getMinLength());
//        System.out.printf("Длина макс:  \t%d\n", fileStatistics.getMaxLength());
//    }

    public static void print(StatisticsReport report, boolean showFull, boolean showShort) {
        if (showFull) {
            printFullStatistic(report);
        } else if (showShort) {
            printShortStatistics(report);
        }
    }

    private static void printFullStatistic(StatisticsReport report) {

    }

    private static void printShortStatistics(StatisticsReport report) {

    }
}
