package lection7.lesson7;

import java.util.Arrays;

public class UsingPerson {

    public UsingPerson() {
        Person[] people = new Person[3];
        people[0] = new Person("Перебийніс", "Василь");
        people[0] = new Person("Козаченко", "Петро");
        people[0] = new Person("Назаренко", "Іван");

        Arrays.sort(people);

        for (Person p : people) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        new UsingPerson();
    }
}
