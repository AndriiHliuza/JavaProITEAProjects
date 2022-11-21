package lection18.lesson18;

import java.io.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class UnPackJar {
    private File destFile;

    public final static int BUFFER = 2_048;

    public void unpack(String destinationDirectory, String nameJar) {
        var sourceJarFile = new File(nameJar);
        try (JarFile jFile = new JarFile(sourceJarFile)) {
            var unzipDir = new File(destinationDirectory);
            var jarFileEntries = jFile.entries();

            while (jarFileEntries.hasMoreElements()) {
                JarEntry entry = jarFileEntries.nextElement();
                var entryname = entry.getName();
                System.out.println("Extracting: " + entryname);
                destFile = new File(unzipDir, entryname);

                File destinationParent = destFile.getParentFile();
                destinationParent.mkdirs();

                if (!entry.isDirectory()) {
                    writeFile(jFile, entry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(JarFile jarFile, JarEntry entry) {
        int currentByte;
        var data = new byte[BUFFER];

        try (BufferedInputStream is = new BufferedInputStream(jarFile.getInputStream(entry))) {
            var fos = new FileOutputStream(destFile);
            var dest = new BufferedOutputStream(fos, BUFFER);

            while ((currentByte = is.read(data, 0, BUFFER)) > 0) {
                dest.write(data, 0, currentByte);
            }
            dest.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
