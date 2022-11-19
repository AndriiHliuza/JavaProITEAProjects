package lection17.hometask17;

/*
Умова:
    дано дві колекції collection1 = Arrays.asList("a1", "a2", "a3", "a1") і collection2 = Arrays.asList("1,2,0", "4,5")
    використовуючи map функції

    Додати "_1" до кожного елемента першої колекції
    У першій колекції прибрати перший символ та повернути масив чисел (int[])
    З другої колекції отримати всі числа, перераховані через кому з усіх елементів
    З другої колекції отримати суму всіх чисел, перерахованих через кому
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        List<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> collection2 = Arrays.asList("1,2,0", "4,5");

        collection1.stream()
                .map(s -> s + "_1")
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        Integer[] a = collection1.stream()
                .map(s -> s.substring(1, s.length()))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(a));

        collection2.stream()
                .map(s -> s + ",")
                .forEach(System.out::print);

        System.out.println();
        int sum = collection2.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .get();
        System.out.println("Sum: " + sum);
    }
}
