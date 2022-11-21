package lection18.lesson18;

import java.io.*;

public class DemoReader {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("data" + File.separator + "res.txt"));

            String tmp = "";

            while ((tmp = bufferedReader.readLine()) != null) {
                String[] s = tmp.split("\\s");

                for (String res : s) {
                    System.out.println(res);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
