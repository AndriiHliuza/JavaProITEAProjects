package lection5.lesson5;

import java.util.Arrays;
import java.util.List;

public class DancerRunner {
    public static void main(String[] args) {
        Dancer dancer = new Dancer("Anton", 18);

        Dancer breakDanceDancer = new BreakDanceDancer("Oleksiy", 19);

        Dancer electricBoogieDancer = new ElectricBoogieDancer("Igor", 20);

        BreakDanceDancer breakDanceDancer1 = new BreakDanceDancer("Bob", 43);
        breakDanceDancer1.dance5();
        ((BreakDanceDancer) breakDanceDancer).dance5();

        Dancer[] discotheque = {dancer, breakDanceDancer, electricBoogieDancer};
        for (Dancer d : discotheque) {
            if (d instanceof BreakDanceDancer) {
                ((BreakDanceDancer) d).dance5();
            } if (d instanceof ElectricBoogieDancer) {
                ((ElectricBoogieDancer) d).dance6();
            } if (d instanceof Dancer){
                d.dance();
            }
        }
    }
}
