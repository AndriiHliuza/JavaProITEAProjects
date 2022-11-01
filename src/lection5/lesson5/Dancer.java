package lection5.lesson5;

public class Dancer {
    private String name;
    private int age;

    public Dancer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void dance() {
        System.out.println(toString() + " I dance like others");
    }
    @Override
    public String toString() {
        return "I am " + name + ", I am " + age + " years old.";
    }
}
