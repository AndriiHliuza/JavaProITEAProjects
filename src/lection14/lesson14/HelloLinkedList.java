package lection14.lesson14;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class HelloLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        Deque<String> list3 = new LinkedList<>();

        list.add("F");
        list.add("B");
        list.add("D");
        list.add("E");
        list.add("C");

        list.addLast("Z");

        list.addFirst("A");

        list.add(1, "A2");

        System.out.println("Original contents of list: " + list);

        list.remove("F");

        list.remove(2);

        System.out.println("Contents of list after deletion: " + list);

        list.removeFirst();
        list.removeLast();

        System.out.println("List after deleting first and last: " + list);

        Object val = list.get(2);

        list.set(2, val + "-Changed");
        System.out.println("List after change: " + list);
    }
}
