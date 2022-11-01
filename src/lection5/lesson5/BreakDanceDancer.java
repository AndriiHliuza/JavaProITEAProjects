package lection5.lesson5;

public class BreakDanceDancer extends Dancer{
    public BreakDanceDancer(String name, int age) {
        super(name, age);
    }
    @Override
    public void dance() {
        System.out.println(toString() + "I dance break-dance");
    }

    public void dance5() {
        System.out.println("break dancer");
    }
}
