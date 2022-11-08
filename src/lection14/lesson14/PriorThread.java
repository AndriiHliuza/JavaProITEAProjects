package lection14.lesson14;

public class PriorThread extends Thread {
    public PriorThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
