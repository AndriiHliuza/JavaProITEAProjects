package lection6.lesson6;

public class SimpleRoom2 extends SimpleRoom{
    protected double height;

    public SimpleRoom2(double width, double length, double height) {
        super(width, length);
        this.height = height;
        System.out.println("SimpleRoom2 created");
    }

    public void info2() {
        System.out.println("Room: width = " + width + ", length = " + length + ", height = " + height);
        System.out.println("Room's square: " + width * length);
        System.out.println("Room's volume: " + width * length * height);
    }

    public static void main(String[] args) {
        SimpleRoom2 simpleRoom2 = new SimpleRoom2(5, 5, 3);

        simpleRoom2.info();

        simpleRoom2.info2();
    }
}
