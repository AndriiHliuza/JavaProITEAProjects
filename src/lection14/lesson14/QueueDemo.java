package lection14.lesson14;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

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
