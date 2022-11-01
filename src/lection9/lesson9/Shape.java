package lection9.lesson9;

public enum Shape {
    RECTANGLE, TRIANGLE, CIRCLE;

    public double defineSquare(double ...x) {
        return switch (this) {
            case RECTANGLE -> x[0] * x[1];
            case TRIANGLE -> x[0] * x[1] / 2;
            case CIRCLE -> Math.pow(x[0], 2) * Math.PI;
            default -> throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        };
    }
}
