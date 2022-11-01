package lection6.hometask6;

public class HenFactory {

    private Hen[] hens;

    public HenFactory(Hen ...hens) {
        this.hens = hens;
    }

    /*
    Метод "getHen" повертає назви всіх країн тих порід курей які вирощуються на фабриці
     */
    public String getHen() {
        String countries = "";

        for (int i = 0; i < hens.length; i++) {
            countries += hens[i].getCountry() + " ";
        }
        return countries;
    }
}
