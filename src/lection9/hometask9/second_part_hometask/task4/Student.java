package lection9.hometask9.second_part_hometask.task4;

import java.time.LocalDate;

public class Student {
    private static int count;
    private int id; // Номер студента
    private int yearOfEntry; // Рік вступу студента
    private String name; // Ім'я студента
    private String surname; // Прізвище студента
    private LocalDate birthday; // Дата народження студента
    private String email; // Email студента
    private String university; // Університет в який поступив студент
    private String faculty; // Факультет на який поступив студент
    private String specialization; // Спеціалізація студента

    public Student(int yearOfEntry, String name, String surname, String birthday, String email, String university, String faculty, String specialization) {
        this.id = ++count;
        this.yearOfEntry = yearOfEntry;
        this.name = name;
        this.surname = surname;
        setBirthDay(birthday);
        setEmail(email);
        this.university = university;
        this.faculty = faculty;
        this.specialization = specialization;
    }

    /**
     * Метод для перевірки правильності введеної дати
     * @param date Поле для вводу дати
     *             Якщо введена дата не підпадає під шаблон YYYY.MM.DD то встановлюється дата 2000.01.01
     *             Якщо день місяця не підпадає під шаблон (0 < день місяця <= 31) то встановлюється дата 2000.01.01
     *             Якщо місяць не підпадає під шаблон (0 < місяця <= 12) то встановлюється дата 2000.01.01
     */
    public void setBirthDay(String date) {

        if (date.matches("\\d{4}\\.((0?\\d)|1[0-2])\\.((0?[1-9])|[1-2]\\d|(30|31))")) {
            String[] dateComponents = date.split("\\.");
            int[] intDateComponents = new int[dateComponents.length];
            for (int i = 0; i < dateComponents.length; i++) {
                if (dateComponents[i].matches("0\\d")) {
                    dateComponents[i] = dateComponents[i].substring(1);
                }
                intDateComponents[i] = Integer.parseInt(dateComponents[i]);
            }
            birthday = LocalDate.of(intDateComponents[0], intDateComponents[1], intDateComponents[2]);
        } else {
            birthday = LocalDate.of(2000, 1, 1);
        }
    }

    /**
     * Метод для перевірки правильності введеного email
     * @param email Поле для вводу email
     */
    public void setEmail(String email) {
        if (email.matches("\\w+@\\w+\\.\\w+")) {
            this.email = email;
        } else {
            this.email = "undefined";
        }

    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return  "ID: " + id +
                ", Рік вступу: " + yearOfEntry +
                ", Ім'я: " + name +
                ", Прізвище: " + surname +
                ", Дата народження: " + birthday +
                ", Email: " + email +
                ", Університет: " + university +
                ", Факультет: " + faculty +
                ", Спеціалізація: " + specialization;
    }
}
