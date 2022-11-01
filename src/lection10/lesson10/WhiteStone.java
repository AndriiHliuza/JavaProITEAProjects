package lection10.lesson10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class WhiteStone extends Stone{


    public WhiteStone() throws IOException, CloneNotSupportedException {
        super();

    }

    @Override
    public void build(String data) {
        System.out.println("White stone");
    }
}
