package lection15.lesson15;

import java.io.File;
import java.io.IOException;

public class SynchroRun {
    public static void main(String[] args) {
        Resource resource = null;

        try {
            resource = new Resource("data" + File.separator + "result.txt");
            SyncThread t1 = new SyncThread("First", resource);
            SyncThread t2 = new SyncThread("Second", resource);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            System.err.println("Error of the file: " + e);
        } catch (InterruptedException e) {
            System.err.println("Error of the thread: " + e);
        } finally {
            if (resource != null) {
                resource.close();
            }

        }
    }
}
