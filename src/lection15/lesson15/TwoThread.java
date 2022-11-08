package lection15.lesson15;

public class TwoThread {
    public static int counter = 0;

    public static void main(String[] args) {
        final StringBuffer stringBuilder = new StringBuffer();
        new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            synchronized (stringBuilder) {
                do {
                    stringBuilder.append("A");
                    System.out.println(stringBuilder);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        System.err.println(e);
//                    }
                } while (counter++ < 2);
            }
        }).start();

        new Thread(() -> {
            synchronized (stringBuilder) {
                while (counter++ < 6) {
//                    try {
//                        Thread.sleep(800);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    stringBuilder.append("B");
                    System.out.println(stringBuilder);
                }
            }
        }).start();
    }
}
