package lection7.lesson7.dictionary;

public interface Dict {
    boolean addWord(String word, String translation);

    boolean delWord(String word);

    String findTranslation(String word);
}
