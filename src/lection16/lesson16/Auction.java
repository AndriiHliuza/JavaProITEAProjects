package lection16.lesson16;

import java.util.*;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;
    public final int BIDS_NUMBER = 5;

    public Auction() {
        bids = new ArrayList<>();
        barrier = new CyclicBarrier(BIDS_NUMBER, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                var winner = defineWinner();
                System.out.println("Bid #" + winner.getBidId() + ", price: " + winner.getPrice() + " win!");
            }
        });
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public boolean add(Bid e) {
        return bids.add(e);
    }

    public Bid defineWinner() {
        return Collections.max(bids, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
}
