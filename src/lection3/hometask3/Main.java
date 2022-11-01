package lection3.hometask3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        Task1
        Створіть масив з 8-ми випадкових цілих чисел з відрізка [1; 10]
         */
        int[] arr1 = new int[8];
        fillArrayRandomly(arr1, 1, 11);

        /*
        Task 2
        Виведіть масив на екран у результаті
         */
        printArr(arr1);


        System.out.println();


        /*
        Task 3
        Замініть кожен елемент з непарним індексом на нуль
         */
        for (int i = 1; i < arr1.length; i += 2) {
            arr1[i] = 0;
        }

        /*
        Task 4
        Знову виведіть масив на екран
         */
        printArr(arr1);

        System.out.println();

        /*
            Створіть масив з 12 випадкових цілих чисел з відрізка [-15; 15].
            Визначте який елемент є в цьому масиві максимальним і повідомте індекс його останнього входження в масив.
         */
        int[] arr2 = new int[12];
        fillArrayRandomly(arr2, -15, 16);
        printArr(arr2);
        int maxElementIndex = 0;
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[maxElementIndex] <= arr2[i]) {
                maxElementIndex = i;
            }
        }
        System.out.println("Максимальний елемент в масиві: " + arr2[maxElementIndex] + " має індекс " + maxElementIndex);

        System.out.println();

        /*
        1. Створіть масив з 4 випадкових цілих чисел з відрізка [10; 99]
         */
        int[] arr3 = new int[4];
        fillArrayRandomly(arr3, 10, 100);

        /*
        2. Виведіть його на екран у рядок.
         */
        printArr(arr3);

        System.out.println();

        /*
        3. Далі визначте і виведіть на екран повідомлення про те, чи є масив строго зростаючої послідовністю.
         */

        boolean isStrictlyGrowing = true;
        for (int i = 0; i < arr3.length - 1; i++) {
            if (arr3[i] > arr3[i+1]) {
                System.out.println("Масив НЕ є строго зростаючою послідовністю");
                isStrictlyGrowing = false;
                break;
            }
        }
        if (isStrictlyGrowing) {
            System.out.println("Масив є строго зростаючою послідовністю");
        }

        System.out.println();

        /*
        Напишіть програму, яка міняє місцями елементи одновимірного масиву з String в зворотному порядку.
        Не використовуйте додатковий масив для зберігання результатів.
         */

        String[] stringArr = {  "Andrii",
                                "Kostya",
                                "Ruslan",
                                "Roman",
                                "John"
        };

        System.out.println("Old array: " + Arrays.toString(stringArr));

        String temp;
        for (int i = 0; i < (stringArr.length/2); i++) {
            temp = stringArr[i];
            stringArr[i] = stringArr[stringArr.length-1-i];
            stringArr[stringArr.length-1-i] = temp;
        }

        System.out.println("New array: " + Arrays.toString(stringArr));

        System.out.println();

        /*
        1. Створіть 2 масива з 5 випадкових цілих чисел з відрізка [0; 5] кожен
        2. Виведіть масиви на екран в двох окремих рядках
         */
        int[][] arrToCollectArrays = new int[2][5]; // Створюю масив для запису в нього двох масивів
        for (int i = 0; i < arrToCollectArrays.length; i++) {
            arrToCollectArrays[i] = new int[5];
            fillArrayRandomly(arrToCollectArrays[i], 0, 6);
            printArr(arrToCollectArrays[i]);
        }
        double firstArrAverageNum = averageNumber(arrToCollectArrays[0]);
        System.out.println("First array average number: " + firstArrAverageNum);
        double secondArrAverageNum = averageNumber(arrToCollectArrays[1]);
        System.out.println("Second array average number: " + secondArrAverageNum);
        if (firstArrAverageNum > secondArrAverageNum) {
            System.out.println("First is bigger");
        } else if (firstArrAverageNum < secondArrAverageNum) {
            System.out.println("Second is bigger");
        } else {
            System.out.println("Numbers are equal");
        }

    }


    public static void printArr(int[] arr) {
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void fillArrayRandomly(int[] arr, int leftBorder, int rightBorder) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(leftBorder, rightBorder);
        }
    }
    public static double averageNumber(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum/arr.length;
    }
}
