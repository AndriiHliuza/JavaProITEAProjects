package lection10.lesson10;

public class Main {
    public static void main(String[] args) {
        CoinRunner coinRunner = new CoinRunner();
        try {
            coinRunner.doAction("-5");
        } catch (CoinException e) {
            throw new RuntimeException(e);
        }

    }
}
