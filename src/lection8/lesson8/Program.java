package lection8.lesson8;

import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Account<String, Integer> acc1 = new Account<>("343", 500, 45);
        Account<Integer, Integer> acc2 = new Account<>(343, 500, new Object());
        Account<Boolean, Integer> acc3 = new Account<>(false, 500, true);

        System.out.println(acc1.getId());
        System.out.println(acc2.getId());
        System.out.println(acc3.getId());

        String a = acc1.getTtt();
        String b = acc2.getTtt();
        String c = acc3.getTtt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

//        Account acc1 = new <Date>Account(new Date(), 67);
//
//        System.out.println(acc1.getId());


    }
}


class Printer {
    public <T> void print(T[] items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
}