package lection15.lesson15;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Market extends Thread {

    private AtomicLong index;

    public Market(AtomicLong index) {
        this.index = index;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                index.addAndGet(random.nextInt(10));
                //index += random.nextInt(10);
                System.out.println("Market current index: " + index);
                Thread.sleep(random.nextInt(500));
                index.addAndGet(-1 * random.nextInt(10));
                //index -= random.nextInt(10);
                System.out.println("Market current index: " + index);
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AtomicLong getIndex() {
        return index;
    }
}
