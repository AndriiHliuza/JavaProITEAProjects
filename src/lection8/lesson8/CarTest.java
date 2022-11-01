package lection8.lesson8;

public class CarTest {
    private static int count;
    private int id;
    private String maker;
    private double price;
    private String year;
    private String color;

    public CarTest() {
        count++;
        id = count;
    }

    public CarTest(String maker, double price, String year, String color) {
        this.maker = maker;
        this.price = price;
        this.year = year;
        this.color = color;
        count++;
        id = count;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        CarTest.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price should be > 0");
        }
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
