package lection9.lesson9;

import java.util.Random;

public class Abonent {
    private long id;
    private String name;
    private String tariffPlan;

    private PhoneNumber phoneNumber;

    public Abonent(long id, String name) {
        this.id = id;
        this.name = name;
    }

    private class PhoneNumber {
        private int countryCode;
        private int netCode;
        private int number;

        public void setCountryCode(int countryCode) {
            this.countryCode = countryCode;
        }

        public void setNetCode(int netCode) {
            this.netCode = netCode;
        }

        public int generateNumber() {
            int temp = new Random().nextInt(10_000_000);
            number = temp;
            return number;
        }
    }

    public void setTariffPlan(String tariffPlan) {
        this.tariffPlan = tariffPlan;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTariffPlan() {
        return tariffPlan;
    }

    public String getPhoneNumber() {
        if (phoneNumber != null) {
            return "+" + phoneNumber.countryCode + "-" + phoneNumber.netCode + "-" + phoneNumber.number;
        }
        return "phone number is empty";
    }

    public void obtainPhoneNumber(int countryCode, int netCode) {
        phoneNumber = new PhoneNumber();
        phoneNumber.setCountryCode(countryCode);
        phoneNumber.setNetCode(netCode);
        phoneNumber.generateNumber();
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tariffPlan='" + tariffPlan + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                '}';
    }
}
