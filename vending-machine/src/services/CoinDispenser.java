package services;

public class CoinDispenser {
    private int nominal;

    public CoinDispenser(int nominal) {
        this.nominal = nominal;
    }

    public String toString() {
        return "Номинал монеты равен " + nominal;
    }

    public int getSum(int insertCoin, int outCoin) {
        return insertCoin + outCoin;
    }

    public int giveChange(int sumCoin, int price) {
        int change;
        if (price < sumCoin) {
            change = sumCoin - price;
        } else change = 0;
        return change;
    }

    public boolean dispense(int price) {
        return false;
    }
}
