package lection6.lesson6.game_runner;

import lection6.lesson6.game.General;
import lection6.lesson6.game.Sergant;
import lection6.lesson6.game.Soldier;

import java.util.Random;

public class TestBattle {
    Soldier soldier1 = new Soldier("soldier");
    Soldier soldier2 = new Soldier("soldier");

    Sergant sergant = new Sergant("Sergant");
    General general = new General("General");

    public TestBattle() {
        // battle(soldier1, soldier2);
        battle(sergant, general);
    }

    public void battle(Soldier soldier1, Soldier soldier2) {
        Random gen = new Random();
        while ((soldier1.isAlive()) && (soldier2.isAlive())) {
            soldier1.hit(soldier2, gen.nextInt(100));
            if (soldier2.isAlive()) {
                soldier2.hit(soldier1, gen.nextInt(100));
            }
        }
        if (!soldier1.isAlive()) {
            System.out.println("------ End of the fight ----- " + soldier2 + " wins");
        } else {
            System.out.println("------ End of the fight ----- " + soldier1 + " wins");
        }
    }

    public static void main(String[] args) {
        new TestBattle();
    }
}
