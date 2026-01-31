package ctf.alsaev.statistics;

public class Statistics {
    private long countNumbers;
    private long countStrings;
    private Double min;
    private Double max;
    private Double sum = 0.0;
    private long minLength;
    private long maxLength;


    public void add(double value) {
        if (countNumbers == 0) {
            min = value;
            max = value;
        } else {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        countNumbers++;
        sum += value;
    }

    public void add(String value) {
        long length = value.length();
        if (countStrings == 0) {
            minLength = length;
            maxLength = length;
        } else {
            minLength = Math.min(minLength, value.length());
            maxLength = Math.max(maxLength, value.length());
        }
        countStrings++;

    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }

    public Double getSum() {
        return sum;
    }

    public long getCountNumbers() {
        return countNumbers;
    }

    public long getCountStrings() {
        return countStrings;
    }

    public long getMaxLength() {
        return maxLength;
    }

    public long getMinLength() {
        return minLength;
    }

    public Double getAverage() {
        return countNumbers == 0 ? 0 : sum / countNumbers;
    }
}
