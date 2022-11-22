package lection18.hometask18.task7;

import lection18.hometask18.FileChanger;

public class Main {
    public static void main(String[] args) {
        FileChanger fileChanger = new FileChanger("src/lection18/hometask18/task7/task7.txt");
        fileChanger.deleteMaxEvenNumberOfWordsInTheLine(3, 5);
    }
}
