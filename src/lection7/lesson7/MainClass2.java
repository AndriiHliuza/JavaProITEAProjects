package lection7.lesson7;

import java.util.Scanner;

public class MainClass2 {
    Scanner scanner;
    CarCost carCost;

    public MainClass2() {
        scanner = new Scanner(System.in);
        System.out.print("Enter country: ");
        String countryName = scanner.nextLine();

        if (countryName.equalsIgnoreCase("Ukraine") || countryName.equalsIgnoreCase("Україна")) {
            carCost = new UkrainePrice();
        } else if (countryName.equalsIgnoreCase("England") || countryName.equalsIgnoreCase("Англія")) {
            carCost = new EnglandPrice();
        } else {
            System.out.println("There is no information about this country");
            return;
        }
        System.out.println("Car's price in " + countryName + ": " + carCost.countLocaleCost());
    }

    public static void main(String[] args) {
        new MainClass2();
    }
}
