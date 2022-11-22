package lection18.hometask18.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class FileWithNumbers {
    private File file;

    public FileWithNumbers(String filePAth) {
        this.file = new File(filePAth);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillFileWithRandomNumbers(int startNumber, int endNumber, int amountOfNumbers) {
        var random = new Random();
        try (var printWriter = new PrintWriter(new BufferedWriter(
                new FileWriter(file)
        ))) {
            for (int i = 0; i < amountOfNumbers; i++) {
                printWriter.printf("%d \n", random.nextInt(startNumber, endNumber + 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortNumbersInFile() {
        String line;
        List<Integer> numbers = new ArrayList<>();
        try (var bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.substring(0, line.length() - 1)));
            }
            numbers.sort(Comparator.naturalOrder());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (var printWriter = new PrintWriter(new BufferedWriter(
                new FileWriter(file)
        ))) {
            for (Integer number : numbers) {
                printWriter.printf("%d \n", number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
