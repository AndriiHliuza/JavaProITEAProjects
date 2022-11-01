package lection7.lesson7.dictionary;

import java.util.Scanner;

public class WordTranslation {
    private Dict dict;

    public WordTranslation(Dict dict) {
        this.dict = dict;

        Scanner scanner = new Scanner(System.in);
        String word = "";

        while (!word.equalsIgnoreCase("ext")){
            System.out.print("Enter word to translate (ext - exit): ");
            word = scanner.next();
            System.out.println(" - " + dict.findTranslation(word));
        } ;
    }
}
