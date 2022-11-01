package lection6.lesson6.game_runner;

import lection6.lesson6.game.General;
import lection6.lesson6.game.Sergant;
import lection6.lesson6.game.Soldier;

import java.util.Random;

public class TestBattle2 {
    Sergant sergant = new Sergant("Sergant");
    General general = new General("General");
    Soldier[] soldiers = new Soldier[100];
    Army army = new Army();

    public TestBattle2() {
        soldiers[0] = new Sergant("Soldier");
        soldiers[1] = new Sergant("Soldier");
        soldiers[2] = new Sergant("Soldier");
        soldiers[3] = new Sergant("Soldier");

        army.addSoldier(battle(sergant, general));
        army.addSoldier(battle(soldiers[0], soldiers[1]));
        army.addSoldier(battle(soldiers[2], soldiers[3]));

        System.out.println("Army's health = " + army.calcArmyHealth());
    }
    public Soldier battle(Soldier soldier1, Soldier soldier2) {
        Random gen = new Random();
        while ((soldier1.isAlive()) && (soldier2.isAlive())) {
            soldier1.hit(soldier2, gen.nextInt(100));
            if (soldier2.isAlive()) {
                soldier2.hit(soldier1, gen.nextInt(100));
            }
        }
        if (!soldier1.isAlive()) {
            System.out.println("------ End of the fight ----- " + soldier2 + " wins");
            return soldier2;
        } else {
            System.out.println("------ End of the fight ----- " + soldier1 + " wins");
            return soldier1;
        }
    }

    public static void main(String[] args) {
        new TestBattle2();
    }
}
