package lection14.lesson14;

public class TalkThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Talking");
            try {
                sleep(20);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
