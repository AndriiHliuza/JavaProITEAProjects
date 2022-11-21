package lection18.lesson18;

import java.io.*;

public class Serializator {
    public boolean serialization(Student student, String fileName) {
        boolean flag = false;
        File file = new File(fileName);
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(student);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не може бути створено: " + e);
        } catch (NotSerializableException e) {
            System.err.println("Клас не підтримує серіалізацію: " + e);
        } catch (IOException e) {
            System.err.println("IO errors: " + e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.err.println("Помилка закриття потоку");
                }
            }
        }
        return flag;
    }

    public Student deserialization(String fileName) throws InvalidObjectException {
        File file = new File(fileName);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (Student) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Class does not exist: " + e);
        } catch (FileNotFoundException e) {
            System.err.println("File for deserialization does not found: " + e);
        } catch (InvalidClassException e) {
            System.err.println("Розбіжність версій класів: " + e);
        } catch (IOException e) {
            System.err.println("General I/O errors: " + e);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    System.err.println("Помилка закриття потоку");
                }
            }
        }
        throw new InvalidObjectException("об'єкт не відновлений");
    }
}
