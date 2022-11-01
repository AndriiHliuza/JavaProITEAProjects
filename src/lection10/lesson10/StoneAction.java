package lection10.lesson10;

import java.io.IOException;
import java.text.ParseException;

public class StoneAction {
    public void buildHouse(Stone stone) {
        try {
            stone.build("some info");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
