package lection5.lesson5;

public class ElectricBoogieDancer extends Dancer{
    public ElectricBoogieDancer(String name, int age) {
        super(name, age);
    }

    @Override
    public void dance() {
        System.out.println(toString() + "I dance electric boogie");
    }

    public void dance6() {
        System.out.println("electric dancer");
    }
}
