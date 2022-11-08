package lection15.lesson15;

public class Broker extends Thread {
    private Market market;
    private String name;
    private static final int PAUSE = 1500;

    public Broker(Market market, String name) {
        this.market = market;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Broker " + name + " Current index: " + market.getIndex());
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
