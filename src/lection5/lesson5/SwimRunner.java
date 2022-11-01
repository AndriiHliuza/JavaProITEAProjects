package lection5.lesson5;

import java.util.Arrays;
import java.util.List;

public class SwimRunner {

    public static void main(String[] args) {
        Swim human = new Human("Anton", 6);
        Swim fish = new Fish("CatFish");
        Swim boat = new UBoat(25);

        List<Swim> swimmers = Arrays.asList(human, fish, boat);

        for (Swim s : swimmers) {
            s.swim();
        }

    }
}
