package lection5.hometask5;

public class Person {
    private String name;
    private String surname;
    private int age;

    private int id;

    public Person(String name, String surname, int age, int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    public void printPersonInformation() {
        System.out.println("Ім'я: " + name + "\n" +
                "Прізвище: " + surname + "\n" +
                "Вік: " + age + "\n" +
                "Номер паспорта: " + id);
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }
}
