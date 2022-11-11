package lection16.lesson16;

public class Consumer extends Subject implements Runnable {
    public Consumer(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {
        try {
            synchronized (item) {
                var requiredNumber = item.getNumber();
                item = exchanger.exchange(item);
                System.out.println("Consumer after: " + item.getNumber());

                if (requiredNumber >= item.getNumber()) {
                    System.out.println("Consumer " + getName() + " підвищує план виробництва товару");
                } else {
                    System.out.println("Consumer " + getName() + " знижує план виробництва товару");

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
