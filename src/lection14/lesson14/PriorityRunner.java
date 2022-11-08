package lection14.lesson14;

public class PriorityRunner {
    public static void main(String[] args) {
        var min = new PriorThread("Min");
        var max = new PriorThread("Max");
        var norm = new PriorThread("Norm");

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);

        min.start();
        norm.start();
        max.start();
    }
}
