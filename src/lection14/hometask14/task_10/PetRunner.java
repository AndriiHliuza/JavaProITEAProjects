package lection14.hometask14.task_10;

import lection14.hometask14.tasks_1_8.Main;

import java.util.HashMap;
import java.util.Map;

public class PetRunner {
    public static void main(String[] args) {
        Map<String, Pet> pets = new HashMap<>();
        pets.put("Tom", new Cat());
        pets.put("Brubo", new Dog());
        pets.put("Gosha", new Parrot());
        pets.put("Charlie", new Dog());
        Main.printKeys(pets);
    }
}
