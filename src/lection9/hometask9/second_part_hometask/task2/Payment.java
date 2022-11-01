package lection9.hometask9.second_part_hometask.task2;

/*
2. Створити клас Payment з внутрішнім класом, за допомогою об'єктів якого можна сформувати покупку з декількох товарів.
Створені класи до завдання:
  - Payment.java
  - PaymentRunner.java
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Payment {
    private ArrayList<Product> purchaseProducts = new ArrayList<>();
    private double priceToPay;
    private double rest;

    private double baseProductPrice = 100;

    private class Product {
        private String productName;
        private int expirationDate;
        private LocalDate productionDate;

        private double price;

        public Product(String productName, double priceIndex) {
            Random random = new Random();
            this.productName = productName;
            this.expirationDate = random.nextInt(4, 11);
            this.productionDate = LocalDate.now().minusDays(random.nextInt(0,5));
            this.price = priceIndex * baseProductPrice;
            priceToPay += price;
        }

        public enum ProductTypes {
            DAIRY(1, "Молоко", "Сметана", "Кефір", "Масло"),
            DRINK(5, "Вода негазована", "Вода газована", "Cola", "Pepsi", "Лимонад"),
            FRUIT(3, "Яблуки", "Груші"),
            VEGETABLE(2, "Буряки", "Помідори", "Огірки"),
            BAKED(4, "Хліб", "Лаваш");

            private double priceIndex;
            private String[] availableProducts;

            ProductTypes(double priceIndex, String ...availableProducts) {
                this.priceIndex = priceIndex;
                this.availableProducts = availableProducts;
            }

            private static boolean isPresent(String productType) {
                for (ProductTypes type : values()) {
                    if (productType.equalsIgnoreCase(type.name())) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String toString() {
                return  "Категорія " + name() + ":" +
                        " (Доступні товари категорії: " + Arrays.toString(availableProducts) + ")";
            }
        }

        @Override
        public String toString() {
            return  "Назва продукції: " + productName +
                    ", Кількість днів для зберігання: " + expirationDate +
                    ", Дата виробництва: " + productionDate +
                    ", Ціна: " + price;
        }
    }

    public boolean addProductToPurchase(String productName, String productCategory) {
        if (Product.ProductTypes.isPresent(productCategory)) {
            Product.ProductTypes productType = Product.ProductTypes.valueOf(productCategory.toUpperCase());
            for (String product : productType.availableProducts) {
                if (productName.equalsIgnoreCase(product)) {
                    purchaseProducts.add(new Product(product, productType.priceIndex));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeProduct(int productNumber) {
        if (productNumber >= 1 && productNumber <= purchaseProducts.size()) {
            priceToPay -= purchaseProducts.get(productNumber - 1).price;
            purchaseProducts.remove(productNumber - 1);
            return true;
        }
        return false;
    }

    public boolean pay(double givenMoney) {
        if (givenMoney >= priceToPay) {
            rest = givenMoney - priceToPay;
            return true;
        }
        return false;
    }

    public double getPriceToPay() {
        return priceToPay;
    }

    public double getRest() {
        return rest;
    }

    public String getAllPurchaseProducts() {
        String allPurchaseProducts = "";
        for (int i = 0; i < purchaseProducts.size(); i++) {
            allPurchaseProducts += (i + 1) + ")" + purchaseProducts.get(i) + "\n";
        }
        return allPurchaseProducts;
    }

    public String getAllAvailableProducts() {
        String allAvailableProducts = "";
        for (Product.ProductTypes productType : Product.ProductTypes.values()) {
            allAvailableProducts += productType + "\n";
        }
        return allAvailableProducts;
    }
}
