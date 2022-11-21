package lection18.lesson18;

import java.io.*;

public class DemoWriter {
    public static void main(String[] args) {
        File file = new File("./data/res.txt");

        double[] v = {1.10, 1.2, 1.401, 5.01, 6.017, 7, 8};
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);

            for (double version : v) {
                printWriter.printf("Java %.2g \n", version);
            }
        } catch (IOException e) {
            System.err.println("Помилка відкриття потоку: " + e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
