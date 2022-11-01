package lection5.lesson5;

public class CoinVolume {
    public static void main(String[] args) {
        double width = 10;
        double height = 20;
        double depth = 40;

        Safe mySafe1 = new Safe(width, height, depth);
        Safe mySafe2 = new Safe(10.0, 15.0, 15.5);

//        mySafe1.setSafeVolume(width, height, depth);
//        mySafe2.setSafeVolume(10.0, 15.0, 15.5);

        printSafeVolume(mySafe1, 1);
        printSafeVolume(mySafe2, 2);
    }
    static void printSafeVolume(Safe safe, int number) {
        System.out.println("Safe № " + number + " has volume: " + safe.getSafeVolume());
    }
}
