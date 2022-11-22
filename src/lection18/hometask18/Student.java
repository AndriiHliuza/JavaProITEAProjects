package lection18.hometask18;

import java.io.Serial;
import java.io.Serializable;


public class Student implements Serializable {
    protected static String faculty;
    private String name;

    private int id;
    private transient String password;

    //private int b;

    @Serial
    private static final long serialVersionUID = 1L;  // hello world

    public Student(String nameOfFaculty, String name, int id, String password) {
        faculty = nameOfFaculty;
        this.name = name;
        this.id = id;
        this.password = password;
    }
    /*
    public void sayHello() {
        System.out.println("Hello");
    }
*/

    public void run() {
        System.out.println("I am running");
    }

    /**
     * Method that say goodbye
     * @param b parameter with type Integer
     * @return integer 20
     */
    public int SayGoodbye(int b) {
        System.out.println("Goodbye");
        return 20;
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
