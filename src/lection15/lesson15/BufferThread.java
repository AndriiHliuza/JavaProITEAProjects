package lection15.lesson15;

public class BufferThread {
    static int counter = 0;
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                 synchronized (stringBuffer) {
                    while (counter++ < 3) {
                        stringBuffer.append("A");
                        System.out.print("> " + counter + " ");
//                        try {
//                            sleep(200);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
                        System.out.println(stringBuffer);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            System.err.print(e);
                        }
                    }
                }
            }
        }.start();

        Thread.sleep(100);
        while (counter++ < 6) {
            System.out.print("< " + counter + " ");
            stringBuffer.append("B");
            System.out.println(stringBuffer);
        }
    }
}
