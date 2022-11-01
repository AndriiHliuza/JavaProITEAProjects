package lection5.hometask5;

public class Student extends Person{
    private String department;
    private double rating;
    private int admissionYear;

    public Student(String name, String surname, int age, int id, String department, double rating, int admissionYear) {
        super(name, surname, age, id);

        this.department = department;
        this.rating = rating;
        this.admissionYear = admissionYear;
    }

    @Override
    public void printPersonInformation() {
        super.printPersonInformation();
        System.out.println("Факультет: " + department + "\n" +
                "Рейтинг: " + rating + "\n" +
                "Рік вступу: " + admissionYear);
    }

    @Override
    public String toString() {
        return "Студент " + super.toString() + ", рейтинг - " + rating;
    }

    public String getDepartment() {
        return department;
    }

    public double getRating() {
        return rating;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }
}
