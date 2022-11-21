package lection18.lesson18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PackDemo {
    public static void main(String[] args) {
        String dirName = "./src/lection18/lesson18";
        PackJar packJar = new PackJar("./example.jar");
        try {
            packJar.pack(dirName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}