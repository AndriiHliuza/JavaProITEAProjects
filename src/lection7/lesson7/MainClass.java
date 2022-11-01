package lection7.lesson7;

public class MainClass {
    CarCost ukrainePrice = null;
    CarCost englandPrice = null;

    public MainClass() {
        this.ukrainePrice = new UkrainePrice();
        this.englandPrice = new EnglandPrice();

        System.out.println("Price of the car in Ukraine is " + ukrainePrice.countLocaleCost());
        System.out.println("Price of the car in England is " + englandPrice.countLocaleCost());
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
