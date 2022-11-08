package lection15.lesson15;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class RunBlocking {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 4; i++) {
                    try {
                        queue.put("Java" + i);
                        System.out.println("Element " + i + " added");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Second thread started");
                    Thread.sleep(2_000);
                    System.out.println("Second thread");
                    System.out.println("Element " + queue.take() + " took");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
