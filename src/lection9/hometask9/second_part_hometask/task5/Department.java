package lection9.hometask9.second_part_hometask.task5;

/*
5. Створити клас Department з внутрішнім класом, за допомогою об'єктів
якого можна зберігати інформацію про всі посадах відділу і про
всіх співробітників, коли-небудь займали конкретну посаду.
Створені класи до завдання:
  - Department.java
  - DepartmentRunner.java
  - JuniorDeveloper.java
  - MiddleDeveloper.java
  - SeniorDeveloper.java
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Department {
    private String departmentName; // Назва відділу
    private String departmentHead; // Голова відділу
    private DepartmentPosition[] departmentPositions; // Доступні посади відділу, які вказуються при створенні відділу
    private ArrayList<Employee> employees = new ArrayList<>(); // Список всіх робітників відділу

    public Department(String departmentName, String departmentHead, DepartmentPosition ...departmentPositions) {
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
        this.departmentPositions = departmentPositions;
    }


    /**
     * Метод для отримання списку всіх робітників відділу
     * @return Строкове представлення списку всіх робітників відділу
     */
    public String getListOfAllDepartmentMembers() {
        String allDepartmentMembers = "";
        for (int i = 0; i < employees.size(); i++) {
            allDepartmentMembers += employees.get(i) + "\n";
        }
        return allDepartmentMembers;
    }

    /**
     * Клас, що представляє робітника відділу
     */
    private class Employee{

        private static int count;

        private int id; // ID робітника
        private String name; // Ім'я робітника
        private String surname; // Прізвище робітника

        /*
        Дата найму на роботу робітника
        Розраховується як поточна дата додавання робітника у відділ методом addNewEmployeeToDepartment у класі Department
         */
        private LocalDate dateOfEmployment;

        /*
        Посада робітника на роботі
        Розраховується методом setDepartmentPosition у класі Employee
         */
        private DepartmentPosition departmentPosition;

        public Employee(String name, String surname, int yearsOfWorkExperience) throws CloneNotSupportedException {
            this.id = ++count;
            this.name = name;
            this.surname = surname;
            this.dateOfEmployment = LocalDate.now();
            setDepartmentPosition(yearsOfWorkExperience);
        }

        /**
         * Метод для призначення посаду новому робітнику. Посада надається робітнику аналізуючи робочий досвід робітника у роках.
         * У ситуації коли посадами у відділу є Junior Developer, Middle Developer, Senior Developer посада розраховується
         * за таким принципом:
         * 1) 0 - 2 роки робочого досвіду - Junior Developer
         * 2) 3 - 5 роки робочого досвіду - Middle Developer
         * 3) 5+ років робочого досвіду - Senior Developer
         * @param yearsOfWorkExperience Досвід роботи робітника у роках
         * @throws CloneNotSupportedException
         */
        private void setDepartmentPosition(int yearsOfWorkExperience) throws CloneNotSupportedException {
            Arrays.sort(departmentPositions);
            for (int i = departmentPositions.length - 1; i > 0; i--) {
                if (yearsOfWorkExperience >= departmentPositions[i].minimumYearsOfWorkExperience) {
                    departmentPosition = departmentPositions[i].clone();
                    return;
                }
            }
        }

        @Override
        public String toString() {
            return "Employee №" + id + ":" +
                    " Ім'я: " + name +
                    ", Прізвище: " + surname +
                    ", Дата найму на роботу: " + dateOfEmployment +
                    ", Позиція: " + departmentPosition;
        }
    }

    /**
     * Клас, що представляє посаду у відділу
     */
    public abstract static class DepartmentPosition implements Cloneable, Comparable<DepartmentPosition> {
        private double salary; // Заробітня плата на посаді
        private int minimumYearsOfWorkExperience; // Мінімальна кількість років робочого досвіду

        private String departmentPositionName; // Назва посади

        public DepartmentPosition(double salary, int minimumYearsOfWorkExperience, String departmentPositionName) {
            this.salary = salary;
            this.minimumYearsOfWorkExperience = minimumYearsOfWorkExperience;
            this.departmentPositionName = departmentPositionName;
        }

        @Override
        public DepartmentPosition clone() throws CloneNotSupportedException {
            return (DepartmentPosition) super.clone();
        }

        @Override
        public String toString() {
            return departmentPositionName;
        }

        @Override
        public int compareTo(DepartmentPosition departmentPosition) {
            return minimumYearsOfWorkExperience - departmentPosition.minimumYearsOfWorkExperience;
        }
    }

    /**
     * Метод для додавання нового робітника до відділу
     * @param name Ім'я робітника
     * @param surname Прізвище робітника
     * @param yearsOfWorkExperience Кількість років робочого досвіду
     * @throws CloneNotSupportedException
     */
    public void addNewEmployeeToDepartment(String name, String surname, int yearsOfWorkExperience) throws CloneNotSupportedException {
        employees.add(new Employee(name, surname, yearsOfWorkExperience));
    }

    @Override
    public String toString() {
        return "Department: " +
                "Назва відділу: " + departmentName +
                ", Голова відділу: " + departmentHead +
                ", Доступні позицію відділу: " + Arrays.toString(departmentPositions);
    }
}
