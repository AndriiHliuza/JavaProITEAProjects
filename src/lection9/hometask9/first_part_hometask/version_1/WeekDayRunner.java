package lection9.hometask9.first_part_hometask.version_1;
/*
Version 1 of WeekDayRunner
holiday - вихідний день (субота, неділя)
 */

public class WeekDayRunner {
    public static void main(String[] args) {
        for (Weekday weekday : Weekday.values()) {
            System.out.println(weekday + " - " + Weekday.getDayStatus(weekday));
        }
    }
}
