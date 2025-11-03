package lotto;

public enum Ranking {
    First(2000000000,0),
    Second(30000000,0),
    Third(1500000,0),
    Forth(50000,0),
    Fifth(5000,0);

    private final int winningAmount;
    private int count;

    Ranking(int winningAmount, int count) {
        this.winningAmount = winningAmount;
        this.count = count;
    }

    public int next() {
        return this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public int getRevenue() {
        return this.winningAmount * this.getCount();
    }

    public static Double getAllRevenueRate(int allRevenue, int purchaseFee) {
        double revenueRate = ((double) allRevenue - (double) purchaseFee) / (double) purchaseFee * 100.0;
        return 100.0 + Math.round(revenueRate * 10.0) / 10.0;
    }
}
