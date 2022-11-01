package lection6.lesson6;

public class Room {
    private double width = 0.0;
    private double length = 0.0;
    private double height = 0.0;

    public Room(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public double calculateCapacity() {
        return width * length * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }
}
