package lection10.lesson10;

public class Ship {
    private int id;

    public static class LifeBoat {
        private int boatId;

        public static void down() {
            System.out.println("boat to  water");
        }

        public void swim() {
            System.out.println("Let's go");
        }
    }
}
