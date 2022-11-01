package lection9.hometask9.first_part_hometask.version_2;

/*
Version 2 of Weekday
holiday - день, тижня якому встановлюється певне свято за допомогою метода setHolidayName
 */

public class WeekDayRunner {
    public static void main(String[] args) {
        Weekday tuesday = Weekday.TUESDAY;
        tuesday.setHolidayName("New Year");
        for (Weekday weekday : Weekday.values()) {
            if (weekday.isHoliday()) {
                System.out.println(weekday + " - " + Weekday.getDayStatus(weekday) + ", Свято: " + weekday.getHolidayName());
            } else {
                System.out.println(weekday +  " - " + Weekday.getDayStatus(weekday));
            }
        }
    }
}
