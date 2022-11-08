package lection15.lesson15;

public class DaemonRunner {
    public static void main(String[] args) {
        var usual = new SimpleThread();
        var daemon = new SimpleThread();
        daemon.setDaemon(true);

        daemon.start();
        usual.start();

        System.out.println("The last operator of main");
    }
}
