package ctf.alsaev.statistics;

public class StringSummaryStatistics {
    private long count;
    private long minLen = Long.MAX_VALUE;
    private long maxLen = Long.MIN_VALUE;

    public void accept(String value) {
        count++;
        long length = value.length();
        minLen = Math.min(minLen, length);
        maxLen = Math.max(maxLen, length);
    }

    public long getCount() {
        return count;
    }

    public long getMaxLen() {
        return maxLen;
    }

    public long getMinLen() {
        return minLen;
    }
}
