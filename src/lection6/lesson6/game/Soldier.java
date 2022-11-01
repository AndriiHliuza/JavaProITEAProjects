package lection6.lesson6.game;

import java.util.Random;

public class Soldier {
    protected int health;
    protected boolean alive = false;
    protected int defense = 0;
    protected static int count = 0;
    private int id = 0;
    protected String rank;

    public Soldier(String rank) {
        this.rank = rank;

        id = ++count;
        health = 100;
        alive = true;
        Random randomGen = new Random();
        defense = randomGen.nextInt(50);
        System.out.println(rank + " № " + id + " is created: health = " + health +
                ", defense = " + defense);
    }

    private void receiveHit(int hit) {
        if (isAlive()) {
            int damage = hit - defense;

            if (damage > 0) {
                health = health - damage;
            } else {
                return;
            }
            if (health <= 0) {
                alive = false;
                System.out.println("[X] " + rank + "№ " + id + " get damage " + damage + "and died");
            } else {
                System.out.println(rank + " № " + id + " get damage " + damage + "and left alive");
            }
        }
    }

    public void hit(Soldier targetSoldier, int hit) {
        targetSoldier.receiveHit(hit);
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return rank + " № " + id + ": health = " + health + ", defense = " + defense;
    }
}
