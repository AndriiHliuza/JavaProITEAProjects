package lection14.lesson14;

public class WalkTalk {
    public static void main(String[] args) {
        TalkThread talk = new TalkThread();
        Thread walk = new Thread(new WalkThread());

        talk.start();
        walk.start();

        System.out.println("Main thread");
    }
}
