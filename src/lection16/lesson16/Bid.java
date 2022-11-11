package lection16.lesson16;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid extends Thread {
    private int bidId;
    private int price;
    private CyclicBarrier barrier;

    public Bid(int bidId, int price, CyclicBarrier barrier) {
        this.bidId = bidId;
        this.price = price;
        this.barrier = barrier;
    }

    public int getBidId() {
        return bidId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client " + bidId + " specifies a price");
            Thread.sleep(new Random().nextInt(3000));
            var delta = new Random().nextInt(50);
            price += delta;
            System.out.println("Bid " + bidId + " : " + price);
            barrier.await();
            System.out.println("Continue to work ...");
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
