package lection18.lesson18;

import java.io.*;

public class WriteRunner {
    public static void main(String[] args) {
        var pArray = new String[]{"2022 ", "Java SE 19"};
        var fByte = new File("data\\byte.data");
        var fSymb = new File("data\\symbol.txt");
        try(var fileOutputStream = new FileOutputStream(fByte); var fileWriter = new FileWriter(fSymb)) {
            for (String a : pArray) {
                fileOutputStream.write(a.getBytes());
                fileWriter.write(a);
            }
        } catch (IOException e) {
            System.err.println("Помилка запису: " + e);
        }
    }
}
