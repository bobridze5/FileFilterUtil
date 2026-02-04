package ctf.alsaev.statistics;

public class StatisticsPrinter {
    public static void print(StatisticsReport report, boolean showFull, boolean showShort) {
        if (showFull) {
            printFullStatistic(report);
        } else if (showShort) {
            printShortStatistics(report);
        }
    }

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

    private static void printHeader(String title) {
        System.out.println("-".repeat(50));
        System.out.println(title);
        System.out.println("-".repeat(50));
    }

    private static void printFooter() {
        System.out.println("-".repeat(50));
        System.out.println();
    }
}
