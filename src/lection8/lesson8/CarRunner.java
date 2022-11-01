package lection8.lesson8;

public class CarRunner {
    public static void main(String[] args) {
        CarTest[] car = new CarTest[5];
        CarTest car1 = new CarTest();
        car1.setMaker("Audi");
        car1.setPrice(10000);
        car1.setYear("2000");
        car1.setColor("red");

        CarTest car2 = new CarTest("BMW", 12000, "2001", "black");
        CarTest car3 = new CarTest("Daewoo", 120, "2001", "black");
        CarTest car4 = new CarTest("Reno", 1200, "2001", "black");

        car[0] = car1;
        car[1] = car2;
        car[2] = car3;
        car[3] = car4;

        for (int i = 0; i < CarTest.getCount(); i++) {
            car[i].getCount();
            System.out.println(car[i]);
        }

        System.out.println(car1);
        System.out.println(car2);

        System.out.println(CarTest.getCount());
    }
}
