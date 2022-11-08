package lection14.hometask14.task_11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OnlineShop {
    private List<Product> catalog = new ArrayList<>();

    private static class Product {
        private String name;
        private double price;
        private int rating;

        public Product(String name, double price, int rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", rating=" + rating +
                    '}';
        }
    }

    public enum TypeOfSorting {
        NAME,
        PRICE,
        RATING
    }

    public List<Product> getCatalog() {
        return catalog;
    }

    public boolean addProductToOnlineShopCatalog(String name, double price, int rating) {
        return catalog.add(new Product(name, price, rating));
    }


    public void printProductsFromCatalog(TypeOfSorting typeOfSorting, boolean reversed) {
        if (typeOfSorting == null) {
            throw new IllegalArgumentException();
        }
        Comparator<Product> comparator;
        comparator = switch (typeOfSorting) {
            case NAME -> Comparator.comparing(Product::getName);
            case PRICE -> Comparator.comparing(Product::getPrice);
            case RATING -> Comparator.comparing(Product::getRating);
        };

        if (reversed) {
            catalog.sort(comparator.reversed());
        } else {
            catalog.sort(comparator);
        }

        for (Product product : catalog) {
            System.out.println(product);
        }
    }
}
