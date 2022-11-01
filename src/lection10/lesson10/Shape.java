package lection10.lesson10;

public enum Shape {
    RECTANGLE,
    SQUARE,
    TRIANGLE {

        int b = myIn();
        int c = myIn2();
        @Override
        public double computeSquare() {
            myFunction();
            return getA() * getB() / 2;
            //return super.computeSquare() / 2;
        }
    };
    private double a;
    private double b;

    private static void myFunction() {
        System.out.println("my function");
    }
    public int myIn() {
        return 5;
    }

    private static int myIn2() {
        return 8;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setShape(double a, double b) {
        if ((a <= 0 || b <= 0) || a != b && this == SQUARE) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
    }

    public double computeSquare() {
        return a * b;
    }

    @Override
    public String toString() {
        return name() + "{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
