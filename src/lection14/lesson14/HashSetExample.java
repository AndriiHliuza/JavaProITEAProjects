package lection14.lesson14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(10, 0.8f);

        System.out.println(set.add("One"));
        System.out.println(set.add("Two"));

        System.out.println(set.add("One"));
        System.out.println(set.add("Three"));

        System.out.println(set.add(null));

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
