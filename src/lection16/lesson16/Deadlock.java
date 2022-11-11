package lection16.lesson16;

public class Deadlock {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + " has bowed to me! \n", name, bower.name);
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed to me! hello! \n", name, bower.name);
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                alphonse.bow(gaston);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 2");
                gaston.bow(alphonse);
            }
        }.start();
    }
}
