package lection14.lesson14;

import java.util.Set;
import java.util.TreeSet;

public class SortedSetDemo {

    public static void main(String[] args) {
        Set<Player> players = new TreeSet<>();

        Player tom = new Player("Tom", 1, 2, 5);
        Player jerry = new Player("Tom", 3, 1, 1);
        Player donald = new Player("Tom", 1, 10, 0);

        players.add(tom);
        players.add(jerry);
        players.add(donald);
        players.add(new Player("Bill", 3, 1, 0));

        for (Player player : players) {
            System.out.println("Player: " + player);
        }
    }
}
