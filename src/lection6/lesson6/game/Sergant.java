package lection6.lesson6.game;

public class Sergant extends Soldier{
    public Sergant(String rank) {
        super(rank);
        health = health * 10;
        System.out.println("Sergant's health was increased by 10 times");
    }
}
