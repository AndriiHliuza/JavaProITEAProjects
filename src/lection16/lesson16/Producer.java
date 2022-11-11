package lection16.lesson16;

public class Producer extends Subject implements Runnable {
    public Producer(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {
        try {
            synchronized (item) {
                var producedNumber = item.getNumber();
                item = exchanger.exchange(item);
                System.out.println("Producer after: " + item.getNumber());

                if (producedNumber <= item.getNumber()) {
                    System.out.println("Producer " + getName() + " підвищує план виробництва товару");
                } else {
                    System.out.println("Producer " + getName() + " знижує план виробництва товару");

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
