package lection6.lesson6;

public class Room2 extends Room{
    public Room2(double width, double length, double height) {
        super(width, length, height);
    }

    @Override
    public double calculateCapacity() {
        return super.calculateCapacity() * 1000;
    }

    public double calculateSquare() {
        return getWidth() * getLength();
    }

    @Override
    public String toString() {
        return "Room's volume = " + calculateCapacity() + "\n" +
                "Room's square = " + calculateSquare();
    }
}
