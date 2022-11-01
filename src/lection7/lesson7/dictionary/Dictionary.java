package lection7.lesson7.dictionary;

public class Dictionary implements Dict{

    private String[] ukWords = {"слово", "читати", "сонце", "робити", "йти"};
    private String[] enWords = {"word", "read", "sun", "do", "go"};

    @Override
    public boolean addWord(String word, String translation) {
        return false;
    }

    @Override
    public boolean delWord(String word) {
        return false;
    }

    @Override
    public String findTranslation(String str) {
        for (int i = 0; i < ukWords.length; i++) {
            if (ukWords[i].compareToIgnoreCase(str) == 0) {
                return enWords[i];
            }
            if (enWords[i].compareToIgnoreCase(str) == 0) {
                return ukWords[i];
            }
        }
        return "----Find no such words in the dictionary----";
    }
}
