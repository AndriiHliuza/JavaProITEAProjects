package lection9.lesson9;

public class TaxiRunner {
    public static void main(String[] args) {
        var ts = TaxiStation.<TaxiStation>valueOf(TaxiStation.class, "Volvo".toUpperCase());
        System.out.println(ts + " : ordinal -> " + ts.ordinal());
        ts.setFreeCabs(3);

        var stations = TaxiStation.values();
        for (TaxiStation station : stations) {
            System.out.println(station);
        }
    }
}
