package lection6.hometask6;

import java.util.Random;

public class PolishHen extends Hen{

    private String country = "Польща";
    @Override
    public int getCountOfEggsPerMonth() {
        Random random = new Random();
        int amountOfEggsPerMonth = 0;
        for (int i = 0; i < 30; i++) {
            int eggsPerDay = random.nextInt(5);
            amountOfEggsPerMonth += eggsPerDay;
        }
        return amountOfEggsPerMonth;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Моя країна - " + country + ". Я несу " + getCountOfEggsPerMonth() + " на місяць";
    }

    @Override
    public String getCountry() {
        return country;
    }
}
