package lection18.hometask18.task1;


public class Main {
    public static void main(String[] args) {
        var fileWithNumbers = new FileWithNumbers("src/lection18/hometask18/task1/task1.txt");
        fileWithNumbers.fillFileWithRandomNumbers(1, 100, 20);
        fileWithNumbers.sortNumbersInFile();
    }
}
