package lection7.lesson7.dictionary;

public class MainClass {
    Dictionary dictionary;
    WordTranslation wordTranslation;

    MainClass() {
        dictionary = new Dictionary();

        wordTranslation = new WordTranslation(dictionary);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
