package ctf.alsaev.statistics;

import java.math.BigDecimal;

public class StatisticsPrinter {
    public static void print(Statistics statistics) {
        System.out.println("*".repeat(10) + " Статистика " + "*".repeat(10));
        System.out.printf("Кол-во чисел:\t%d\n", statistics.getCountNumbers());
        System.out.printf("Кол-во строк:\t%d\n", statistics.getCountStrings());
        System.out.printf("Среднее:     \t%s\n", BigDecimal.valueOf(statistics.getAverage()).toPlainString());
        System.out.printf("Сумма:       \t%s\n", BigDecimal.valueOf(statistics.getSum()).toPlainString());
        System.out.printf("Максимум:    \t%s\n", BigDecimal.valueOf(statistics.getMax()).toPlainString());
        System.out.printf("Минимум:     \t%s\n", BigDecimal.valueOf(statistics.getMin()).toPlainString());
        System.out.printf("Длина мин:   \t%d\n", statistics.getMinLength());
        System.out.printf("Длина макс:  \t%d\n", statistics.getMaxLength());
    }
}
