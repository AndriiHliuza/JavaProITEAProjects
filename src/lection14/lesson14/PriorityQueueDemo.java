package lection14.lesson14;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());

        queue.offer("E");
        queue.offer("A");
        queue.offer("M");

        queue.add("G");
        queue.add("B");

        while (true) {
            String name = queue.poll();
            if (name == null) {
                break;
            }
            System.out.println("Size: " + queue.size());
            System.out.println("Name = " + name);
        }
    }
}
