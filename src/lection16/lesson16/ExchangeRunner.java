package lection16.lesson16;

public class ExchangeRunner {
    public static void main(String[] args) {
        Item ss1 = new Item(32, 2200);
        Item ss2 = new Item(35, 2100);
        new Thread(new Producer("HP", ss1)).start();
        new Thread(new Consumer("RETAIL Trade", ss2)).start();
    }
}
