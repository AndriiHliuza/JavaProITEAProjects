package lection17.hometask17;

/*
    Умова:
    Дана колекція рядків Arrays.asList("a1", "b2", "c3", "a1")
    використовуючи collect та toArray

    Отримати список без дублікатів
    Отримати масив рядків без дублікатів та у верхньому регістрі
    Об'єднати всі елементи в один рядок через роздільник ':' і обернути тегами <b>… </b>
    Перетворити на map, де перший символ ключ, другий символ значення
    Перетворити на map, згрупувавши за першим символом рядки
    Перетворити на map, згрупувавши за першим символом рядки і об'єднаємо другі символи через ':'
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1", "b2", "c3", "a1");

        var modifiedList = list.stream()
                .distinct()
                .toList();
        System.out.println(modifiedList);

        var array = list.stream()
                .distinct()
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        String string = list.stream()
                .collect(Collectors.joining(":", "<b>", "</b>"));
        System.out.println(string);

        var map = list.stream()
                .distinct()
                .collect(Collectors.toMap(k -> k.charAt(0), v -> v.charAt(v.length() - 1)));
        System.out.println(map);

        var map2 = list.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map2);

        var map3 = list.stream()
                .collect(Collectors.groupingBy(
                        s -> s.charAt(0),
                        Collectors.mapping(s -> s.substring(1), Collectors.joining(":"))
                ));
        System.out.println(map3);
    }
}
