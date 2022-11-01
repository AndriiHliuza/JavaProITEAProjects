package lection8.hometask8;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private double price;

    public Book(String name, String author, String publisher, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 10) {
            this.price = 10;
            return;
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }

    public void printBookInfo() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Book book = new Book("Angels and Demons", "Den Brown", "USA", 200);
        book.printBookInfo();
    }
}
