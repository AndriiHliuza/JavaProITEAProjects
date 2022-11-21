package lection18.lesson18;

import java.io.*;

public class ReadDemo {
    public static void main(String[] args) {
        var filePath = "data\\file.txt";
        var file = new File(filePath);
        int b, count = 0;
        FileReader fileReader = null;
        //FileInputStream fileReader = null;
        try {
            fileReader = new FileReader(file);
            //fileReader = new FileInputStream(file);

            while ((b = fileReader.read()) != -1) {
                System.out.print((char) b);
                count++;
            }
            System.out.print("\nчисло байтів = " + count);
        } catch (FileNotFoundException e) {
            System.err.println("Помилка файлу: " + e);
        } catch (IOException e) {
            System.err.println("Помилка читання: " + e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.err.println("Помилка закриття: " + e);
            }
        }
    }
}
