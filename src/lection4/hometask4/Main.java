package lection4.hometask4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Task 1
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string to check if it is a pallindrome: ");
        String palindrome = scanner.nextLine();
        if (isPalindrome(palindrome)) {
            System.out.println("Your string: \"" + palindrome + "\" is palindrome");
        } else {
            System.out.println("Your string: \"" + palindrome + "\" is not palindrome");
        }

        //Task 2
        System.out.print("String 1: ");
        String firstStr = scanner.nextLine();

        System.out.print("String 2: ");
        String secondStr = scanner.nextLine();

        System.out.println("The concatenated string: " + firstStr + " " + secondStr);

        // Task 3
        System.out.print("String 1: ");
        firstStr = scanner.nextLine();

        System.out.print("String 2: ");
        secondStr = scanner.nextLine();

        if (firstStr.compareToIgnoreCase(secondStr) == 0) {
            System.out.println(firstStr + " is equal to " + secondStr);
        } else {
            System.out.println(firstStr + " is not equal to " + secondStr);
        }

        // Task 4
        System.out.print("Enter string: ");
        String str = scanner.nextLine();
        System.out.println("The given string: " + str);
        System.out.println(getWordSymbolsAtEvenPositions(str));
    }

    public static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s*", "");
        if (str.length() % 2 == 0) {
            return str.substring(0, (str.length() / 2))
                    .equalsIgnoreCase(new StringBuffer(str.substring((str.length() / 2), str.length()))
                            .reverse()
                            .toString());
        } else {
            return str.substring(0, (str.length() / 2))
                    .equalsIgnoreCase(new StringBuffer(str.substring((str.length() / 2) + 1, str.length()))
                            .reverse()
                            .toString());
        }
    }
    public static String getWordSymbolsAtEvenPositions(String str) {
        String[] strArr;

        strArr = str.split("\\b");  // Розбиваємо рядок на слова та розділові знаки
        str = "";
        for (String word : strArr) {
            if (word.matches("\\w+")) { // Знаходимо в рядку лише слова відкидаючи розділові знаки
                str += word + " ";
            }
        }
        strArr = str.split("\\s");
        str = "";
        for (String word : strArr) {
            for (int i = 0; i < word.length(); i += 2) { // В кожному слові рядка шукаємо лише символи, що мають парний індекс
                str += word.charAt(i);
            }
            str += " ";
        }
        return str;
    }
}
