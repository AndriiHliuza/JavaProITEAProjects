package lection18.lesson18;

import java.io.InvalidObjectException;

public class RunnerSerialization {
    public static void main(String[] args) {
        Student student = new Student("MMF", "Goncharenko", 1, "G017s9");
        System.out.println(student);

        String file = "data\\demo.data";
        Serializator serializator = new Serializator();
        boolean result = serializator.serialization(student, file);
        Student.faculty = "GEO";

        Student res = null;

        try {
            res = serializator.deserialization(file);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }

        System.out.println(res);
    }
}
