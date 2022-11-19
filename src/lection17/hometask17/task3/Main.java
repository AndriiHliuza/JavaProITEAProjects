package lection17.hometask17.task3;

/*
    Умова:
    дано дві колекції колекція рядків Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4") та колекція людей класу People (з полями name - ім'я, age - вік, sex - Підлога), виду Arrays.asList (New People ("Вася", 16, Sex.MAN), New People ("Петя", 23, Sex.MAN), New People ("Олена", 42, Sex.WOMEN) , New People («Іван Іванович», 69, Sex.MAN)).

    Відсортувати колекцію рядків за абеткою
    Відсортувати колекцію рядків за абеткою у зворотному порядку
    Відсортувати колекцію рядків за алфавітом та прибрати дублікати
    Відсортувати колекцію рядків за алфавітом у зворотному порядку та прибрати дублікати
    Відсортувати колекцію людей на ім'я у зворотному алфавітному порядку
    Відсортувати колекцію людей спочатку за статтю, а потім за віком
    Знайти максимальне значення серед колекції рядків
    Знайти мінімальне значення серед колекції рядків
    Знайдемо людину з максимальним віком
    Знайдемо людину з мінімальним віком
 */

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
        List<People> people = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Олена", 42, Sex.WOMAN),
                new People("Іван Іванович", 69, Sex.MAN)
                );

        strings.stream()
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        strings.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        strings.stream()
                .distinct()
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        strings.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        people.stream()
                .map(People::getName)
                .sorted(Collator.getInstance(new Locale("uk", "UA")).reversed())
                .forEach(System.out::println);

        System.out.println();
        people.stream()
                .sorted(Comparator.comparing(People::getSex).thenComparing(People::getAge))
                .forEach(System.out::println);

        var max = strings.stream()
                .max(Comparator.naturalOrder())
                .get();
        System.out.println("Max: " + max);

        var min = strings.stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println("Min: " + min);

        var maxAgePerson = people.stream()
                .max(Comparator.comparing(People::getAge))
                .get();
        System.out.println(maxAgePerson);

        var minAgePerson = people.stream()
                .min(Comparator.comparing(People::getAge))
                .get();
        System.out.println(minAgePerson);
    }
}
