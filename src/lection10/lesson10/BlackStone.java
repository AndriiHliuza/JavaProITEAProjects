package lection10.lesson10;

import java.io.FileNotFoundException;

public class BlackStone extends Stone{

    public BlackStone() throws FileNotFoundException {

    }

    @Override
    public void build(String data) throws FileNotFoundException {
        System.out.println("Black stone");
    }
}
