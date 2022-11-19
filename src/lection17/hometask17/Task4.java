package lection17.hometask17;

/*
    Умова:
    Дана колекція чисел Arrays.asList(1, 2, 3, 4, 2)
    за допомогою reduce.

    Отримати суму чисел або повернути 0
    Повернути максимум або -1
    Повернути суму непарних чисел або 0
 */

import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2);

        var sum = list.stream()
                .reduce((x, y) -> x + y)
                .orElse(0);
        System.out.println("Sum: " + sum);

        var max = list.stream()
                .reduce((x, y) -> x > y ? x : y)
                .orElse(-1);
        System.out.println("Max: " + max);

        var sumOfOddNumbers = list.stream()
                .reduce((sumOfNumbers, x) -> {
                    if (x % 2 != 0) {
                        return sumOfNumbers + x;
                    } else {
                        return sumOfNumbers;
                    }
                }).orElse(0);
        System.out.println("Sum of odd numbers: " + sumOfOddNumbers);
    }
}
