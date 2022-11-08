package lection14.lesson14;

public class WalkThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Walking");
            try {
                Thread.sleep(13);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
