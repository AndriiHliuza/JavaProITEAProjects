package lection17.hometask17;

/*
    Умова:
    дана колекція рядків Arrays.asList("a1", "a2", "a3", "a1")
    використовуючи методи filter, findFirst, findAny, skip та count:

    Повернути кількість входжень об'єкта «a1»
    Повернути перший елемент колекції або 0, якщо колекція порожня
    Повернути останній елемент колекції або empty, якщо колекція порожня
    Знайти елемент у колекції рівний «a3» або кинути помилку
    Повернути третій елемент колекції по порядку
    Повернути два елементи починаючи з другого
    Вибрати всі елементи шаблону (елемент має 1 у імені)
 */


import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task1 {
    public static void main(String[] args) {
        var list = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.println("Number of 'a1' elements in the list: " +
                list.stream()
                        .filter(s -> s.equals("a1"))
                        .count());


        var firstElem = list.stream()
                .findFirst()
                .orElse("0");

        System.out.println("First element: " + firstElem);


        var lastElem = list.stream()
                .skip(list.stream().count() - 1)
                .findFirst().orElse("empty");
        System.out.println("Last element: " + lastElem);

        var a3 = list.stream()
                .filter(s -> s.equals("a3"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("a3: " + a3);

        var thirdElem = list.stream()
                .skip(2)
                .findFirst()
                .orElse("List has size less then 3 elements");
        System.out.println("Third element: " + thirdElem);

        list.stream()
                .skip(1)
                .limit(2)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        list.stream()
                .filter(s -> s.matches(".*1.*"))
                .forEach(s -> System.out.print(s + " "));
    }
}
