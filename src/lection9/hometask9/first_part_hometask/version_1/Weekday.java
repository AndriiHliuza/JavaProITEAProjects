package lection9.hometask9.first_part_hometask.version_1;
/*
Version 1 of Weekday
holiday - вихідний день (субота, неділя)
 */


public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public boolean isWeekDay() {
        for (int i = 0; i < SATURDAY.ordinal(); i++) {
            if (this.ordinal() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean isHoliday() {
        for (int i = SATURDAY.ordinal(); i < values().length; i++) {
            if (this.ordinal() == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWeekDayExists(String weekDay) {
        for (Weekday weekday : Weekday.values()) {
            if (weekDay.equalsIgnoreCase(weekday.toString())) {
                return true;
            }
        }
        return false;
    }

    public static String getDayStatus(Weekday weekday) {
        if (weekday.isWeekDay()) {
            return "будній день";
        } else {
            return "вихідний день";
        }
    }
}
