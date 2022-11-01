package lection6.lesson6.game;

public class General extends Soldier{

    private String slogan = "Never give up";

    public General(String rank) {
        super(rank);
        health = health * 100;
        System.out.println("General's health was increased by 100 times");
    }

    @Override
    public String toString() {
        return "General with health " + health + " his losung " + slogan;
    }

    public String getSlogan() {
        return slogan;
    }
}
