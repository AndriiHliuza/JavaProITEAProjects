package lection14.lesson14;

public class Player implements Comparable<Player>{

    private String name;
    private int goldMedal;
    private int silverMedal;
    private int bronzeMedal;

    public Player(String name, int goldMedal, int silverMedal, int bronzeMedal) {
        this.name = name;
        this.goldMedal = goldMedal;
        this.silverMedal = silverMedal;
        this.bronzeMedal = bronzeMedal;
    }

    @Override
    public int compareTo(Player o) {
        int value = goldMedal - o.goldMedal;
        if (value != 0) {
            return - value;
        }

        value = silverMedal - o.silverMedal;
        if (value != 0) {
            return - value;
        }

        value = bronzeMedal - o.bronzeMedal;
        return - value;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", goldMedal=" + goldMedal +
                ", silverMedal=" + silverMedal +
                ", bronzeMedal=" + bronzeMedal +
                '}';
    }
}
