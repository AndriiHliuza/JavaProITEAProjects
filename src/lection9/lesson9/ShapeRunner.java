package lection9.lesson9;

public class ShapeRunner {
    public static void main(String[] args) {
        var x = 2.0;
        var y = 3.0;

        var shape = Shape.RECTANGLE;

        System.out.printf("%10s = %5.2f %n", shape, shape.defineSquare(x, y));

        shape = Shape.TRIANGLE;

        System.out.printf("%10s = %5.2f %n", shape, shape.defineSquare(x, y));

        shape = Shape.CIRCLE;

        System.out.printf("%10s = %5.2f %n", shape, shape.defineSquare(x));
    }
}
