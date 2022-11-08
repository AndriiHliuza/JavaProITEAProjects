package lection14.hometask14.tasks_1_8;

public class Product {
    private String firm;
    private String producerCountry;

    public Product(String firm, String producerCountry) {
        this.firm = firm;
        this.producerCountry = producerCountry;
    }

    @Override
    public String toString() {
        return "Product{" +
                "firm='" + firm + '\'' +
                ", producerCountry='" + producerCountry + '\'' +
                '}';
    }
}
