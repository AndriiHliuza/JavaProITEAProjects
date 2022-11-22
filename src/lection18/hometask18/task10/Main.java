package lection18.hometask18.task10;

import lection18.hometask18.FileChanger;

public class Main {
    public static void main(String[] args) {
        FileChanger fileChanger = new FileChanger("src/lection18/hometask18/task10/task10.txt");
        fileChanger.changeLastAndFirstWordOFTheLine();
    }
}
