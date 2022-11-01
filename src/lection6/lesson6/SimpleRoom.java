package lection6.lesson6;

public class SimpleRoom {
    protected double width = 0.0;
    protected double length = 0.0;

    public SimpleRoom(double width, double length) {
        this.width = width;
        this.length = length;
        System.out.println("SimplRoom created");
    }

    public void info() {
        System.out.println("Room: width = " + width + ", length = " + length);
        System.out.println("Room's square: " + width * length);
    }

    public static void main(String[] args) {
        SimpleRoom simpleRoom = new SimpleRoom(5, 5);
        simpleRoom.info();
    }
}
