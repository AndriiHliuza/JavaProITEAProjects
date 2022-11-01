package lection9.lesson9;

public class MobilMain {
    public static void main(String[] args) {
        var abonent = new Abonent(819002, "Andrii H");
        abonent.setTariffPlan("free");
        abonent.obtainPhoneNumber(380, 98);
        System.out.println(abonent);

    }
}
