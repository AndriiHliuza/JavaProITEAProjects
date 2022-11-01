package lection5.lesson5;

public class Fish implements Swim{
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println("Я риба " + name + ". Я пливу, рухаючи плавниками.");
    }

    @Override
    public String test() {
        return Swim.super.test();
    }

    @Override
    public void test2() {
        Swim.super.test2();
    }
}
