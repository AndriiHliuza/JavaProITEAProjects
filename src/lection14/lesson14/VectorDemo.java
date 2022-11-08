package lection14.lesson14;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>(10, 5);

        v.add(123);
        v.add(245);
        v.add(new Integer(345));

        v.add(null);

        System.out.println("Size: " + v.size());

        Integer i = v.elementAt(1);
        System.out.println("Element index 1 = " + i);

        v.setElementAt(1000, 1);
        System.out.println("New value: " + v.get(1));
    }
}
