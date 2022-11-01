package lection9.lesson9;
// This is my extra class №2
public class MyClass {
    public static Ship.Engine createHello(int id) {
        class Rector extends Ship.Engine {
            public Rector(Ship ship) {
                ship.super();
            }
        }
        Ship ship = new Ship();
        return new Rector(ship);
    }

    private static boolean isRector(int id) {
        return id == 6;
    }
}
