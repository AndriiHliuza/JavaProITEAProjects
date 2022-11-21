package lection18.lesson18;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        var fp = new File("src/lection18/lesson18/FileTest2.java");
        if (fp.exists()) {
            System.out.println(fp.getName() + " існує");

            if (fp.isFile()) {
                System.out.println("Шлях до файлу: " + fp.getPath());
                System.out.println("Абсолютний шлях: " + fp.getAbsolutePath());
                System.out.println("Розмір файлу: " + fp.length());
                System.out.println("Остання модифікація: " + new Date(fp.lastModified()));
                System.out.println("Файл доступний для читання: " + fp.canRead());
                System.out.println("Файл доступний для запису: " + fp.canWrite());
                System.out.println("Файл доступний для виконання: " + fp.canExecute());
                System.out.println("Файл видалений: " + fp.delete());
            }
        } else {
            System.out.println("Файл " + fp.getName() + " не існує");
        }
        try {
            if (fp.createNewFile()) {
                System.out.println("Файл " + fp.getName() + " створений");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        var dir = new File("src/lection18/lesson18");

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Каталог " + dir.getName() + " існує");
        }

        var files = dir.listFiles();
        for (File file : files) {
            var date = new Date(file.lastModified());
            System.out.print("\n" + file.getPath() + "\t |" + file.length() + "\t |" + date);
        }

        var roots = File.listRoots();

        if (roots != null) {
            for (File file : roots) {
                System.out.printf("\n %s %d from %d free.", file.getPath(), file.getUsableSpace(), file.getTotalSpace());
            }
        } else {
            System.out.println("there are no roots");
        }
    }
}
