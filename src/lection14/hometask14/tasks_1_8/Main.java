package lection14.hometask14.tasks_1_8;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        1.  а) Створити динамічний масив, що містить об'єкти класу HeavyBox.
            б) Роздрукувати його, використовуючи for each.
            в) Змінити вагу першого ящику на 1.
            г) Видалити останній ящики.
            д) Видалити всі ящики.
         */
        System.out.println("------Task1------");
        LinkedList<HeavyBox> heavyBoxes = new LinkedList<>();
        heavyBoxes.add(new HeavyBox(2));
        heavyBoxes.add(new HeavyBox(3));
        heavyBoxes.add(new HeavyBox(1));
        heavyBoxes.add(new HeavyBox(5));

        for (HeavyBox heavyBox : heavyBoxes) {
            System.out.println(heavyBox);
        }

        heavyBoxes.get(0).setWeight(1);
        heavyBoxes.removeLast();
        heavyBoxes.clear();

        /*
        2. Отримати масив, що містить об'єкти класу HeavyBox з колекції трьома способами і вивести на консоль.
         */
        System.out.println("\n------Task2------");
        heavyBoxes.addAll(List.of(new HeavyBox(2),
                new HeavyBox(3),
                new HeavyBox(1),
                new HeavyBox(5)));

        HeavyBox[] heavyBoxesArray = heavyBoxes.toArray(new HeavyBox[0]);
        System.out.println(Arrays.toString(heavyBoxesArray));

        HeavyBox[] heavyBoxesArray2 = Arrays.copyOf(heavyBoxes.toArray(), heavyBoxes.toArray().length, HeavyBox[].class);
        System.out.println(Arrays.toString(heavyBoxesArray2));

        HeavyBox[] heavyBoxesArray3 = new HeavyBox[heavyBoxes.size()];
        System.arraycopy(heavyBoxes.toArray(), 0, heavyBoxesArray3, 0, heavyBoxesArray3.length);
        System.out.println(Arrays.toString(heavyBoxesArray3));

        /*
        3. Створити TreeSet, що містить HeavyBox. HeavyBox має реалізувати інтерфейс Comparable. Надрукувати вміст за допомогою for each.
         */
        System.out.println("\n------Task3------");
        TreeSet<HeavyBox> heavyBoxTreeSet = new TreeSet<>(List.of(new HeavyBox(2),
                new HeavyBox(3),
                new HeavyBox(1),
                new HeavyBox(5)));
        for (HeavyBox heavyBox : heavyBoxTreeSet) {
            System.out.println(heavyBox);
        }

        /*
        4. Користувач вводить набір чисел у вигляді одного рядка "1, 2, 3, 4, 4, 5". Позбутися повторюваних елементів у рядку і вивести результат на екран.
         */
        System.out.println("\n------Task4------");
        printUniqueNumbers();

        /*
        5. Напишіть методи union(Set<?>... set) та intersect(Set<?> ... set), що реалізують операції об'єднання та перетину множин. Протестуйте роботу цих методів на попередньо заповнених множинах.
         */
        System.out.println("\n------Task5------");
        HashSet<Integer> set1 = new HashSet<>(List.of(new Integer[] {
                2, 3, 7, 1, 4, 2
        }));
        HashSet<Integer> set2 = new HashSet<>(List.of(new Integer[] {
                5, 3, 7, 1, 6, 2
        }));
        HashSet<String> set3 = new HashSet<>(List.of(new String[] {
                "2", "3", "10", "j", "h", "j"
        }));
        System.out.println("Union: " + union(set1, set2, set3) + "\n");
        System.out.println("Intersect: " + intersect(set1, set2, set3));

        /*
        6. Створити чергу, що містить об'єкти класу HeavyBox. Використовуємо клас ArrayDeque. Розмістити об'єкти в чергу за допомогою методу offer(). Видалити об'єкти методом poll().
         */
        ArrayDeque<HeavyBox> heavyBoxArrayDeque = new ArrayDeque<>();
        heavyBoxArrayDeque.offer(new HeavyBox(2));
        heavyBoxArrayDeque.offer(new HeavyBox(3));
        heavyBoxArrayDeque.offer(new HeavyBox(1));
        heavyBoxArrayDeque.offer(new HeavyBox(5));

        heavyBoxArrayDeque.poll();
        heavyBoxArrayDeque.poll();
        heavyBoxArrayDeque.poll();
        heavyBoxArrayDeque.poll();


        /*
        7. Створити колекцію, яка містить об'єкти HeavyBox. Написати метод, який перебирає елементи колекції та перевіряє вагу коробок. Якщо вага коробки більша за 300 гр, коробка переміщається в іншу колекцію.
         */
        System.out.println("\n------Task7------");
        Collection<HeavyBox> heavyBoxArrayList = new ArrayList<>(List.of(new HeavyBox(2),
                new HeavyBox(301),
                new HeavyBox(10),
                new HeavyBox(1500)));
        Collection<HeavyBox> anotherHeavyBoxArrayList = new ArrayList<>();
        checkHeavyBoxWeight(heavyBoxArrayList, anotherHeavyBoxArrayList);
        System.out.println("All heavy boxes: " + heavyBoxArrayList);
        System.out.println("Heavy boxes where weight > 300: " + anotherHeavyBoxArrayList);

        /*
        8.  Створіть HashMap, що містить пари значень - ім'я іграшки та об'єкт іграшки (клас Product).
            Перебрати та роздрукувати пари значень – entrySet().
            Перебрати та роздрукувати набір із імен продуктів - keySet().
            Перебрати та роздрукувати значення продуктів – values(). Для кожного перебору створити свій метод.
         */
        System.out.println("\n------Task8------");
        HashMap<String, Product> productHashMap = new HashMap<>();
        productHashMap.put("Ball", new Product("SportFirm", "USA"));
        productHashMap.put("Doll", new Product("DollFirm", "UK"));
        productHashMap.put("Car", new Product("ToyFirm", "Ukraine"));
        productHashMap.put("Lego", new Product("LegoFirm", "USA"));
        printKeysAndValues(productHashMap);
        printKeys(productHashMap);
        printValues(productHashMap);
    }

    public static void printKeysAndValues(Map<?, ?> map) {
        for (Map.Entry<?, ?> productEntry : map.entrySet()) {
            System.out.println(productEntry.getKey() + " : " + productEntry.getValue());
        }
    }

    public static void printKeys(Map<?, ?> map) {
        for (Object key : map.keySet()) {
            System.out.println(key);
        }
    }

    public static void printValues(Map<?, ?> map) {
        for (Object values : map.values()) {
            System.out.println(values);
        }
    }

    public static void printUniqueNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers: ");
        String numbers = scanner.nextLine();
        HashSet<Integer> integerHashSet = new HashSet<>(numbers.split(" ").length);
        for (String number : numbers.split(" ")) {
            try {
                integerHashSet.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                System.err.println("'" + number + "' is not a number");
            }
        }
        System.out.println(integerHashSet);
    }

    public static Set<Object> union(Set<?> ...set) {
        Set<Object> resultSet = new HashSet<>();
        for (int i = 0; i < set.length; i++) {
            System.out.println("Set " + (i + 1) + ": " + set[i]);
            resultSet.addAll(set[i]);
        }
        return resultSet;
    }

    public static Set<Object> intersect(Set<?> ...set) {
        for (int i = 0; i < set.length; i++) {
            System.out.println("Set " + (i + 1) + ": " + set[i]);
            set[0].retainAll(set[i]);
        }
        return new HashSet<>(set[0]);
    }

    public static void checkHeavyBoxWeight(Collection<HeavyBox> srcCollection, Collection<HeavyBox> anotherCollection) {
        ArrayList<HeavyBox> srcArrayList = new ArrayList<>(srcCollection);
        for (int i = 0; i < srcArrayList.size(); i++) {
            if (srcArrayList.get(i).getWeight() > 300) {
                anotherCollection.add(srcArrayList.get(i));
                srcArrayList.remove(i);
                i--;
            }
        }
    }
}
