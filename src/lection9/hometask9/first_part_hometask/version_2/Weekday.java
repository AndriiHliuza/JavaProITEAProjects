package lection9.hometask9.first_part_hometask.version_2;

/*
Version 2 of Weekday
holiday - день тижня якому встановлюється певне свято за допомогою метода setHolidayName
 */

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private String holidayName;
    private boolean isHoliday;
    public void setHolidayName(String holidayName) {
        if ((holidayName != null) && (!holidayName.equals(""))) {
            this.holidayName = holidayName;
            isHoliday = true;
        }
    }

    public String getHolidayName() {
        return holidayName;
    }

    public boolean isWeekDay() {
        return !isHoliday;
    }

    public boolean isHoliday() {
        return isHoliday;
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
        if (weekday.isHoliday) {
            return "святковий день";
        } else {
            return "звичайний день";
        }
    }
}
