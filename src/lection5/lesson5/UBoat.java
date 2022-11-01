package lection5.lesson5;

public class UBoat implements Swim{
    private int speed;

    public UBoat(int speed) {
        this.speed = speed;
    }

    @Override
    public void swim() {
        System.out.println("Підводний човен пливе, обертаючи гвинти, зі швидкістю " + speed + " вузлів");
    }
}
