package lection14.lesson14;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>(Comparator.reverseOrder());

        map.put("01000005", "Tom");
        map.put("01000002", "Jerry");
        map.put("01000003", "Tom");
        map.put("01000004", "Donald");

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("Phone: " + key);
        }

        System.out.println("------");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println("Phone: " + entry.getKey() + " : " + entry.getValue());
        }
    }
}
