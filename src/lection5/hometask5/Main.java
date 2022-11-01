package lection5.hometask5;

public class Main {
    public static void main(String[] args) {

        // Створення групи з 10 людей
        StudentsGroup studentsGroup = new StudentsGroup(10);


        // Приклад додавання студентів в групу

        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Andrew", "Smith", 19, 234567,
                "Department of IT", 92, 2019)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Bob", "Biden", 22, 234467,
                "Department of journalism", 94, 2020)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Bob", "Biden", 18, 235877,
                "Department of economics", 96, 2019)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Robert", "Brown", 21, 233757,
                "Department of journalism", 99, 2022)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Mary", "Johnson", 18, 238609,
                "Department of Aircrafting", 78, 2022)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Sofia", "Williams", 18, 238767,
                "Department of IT", 98, 2020)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Mary", "Davis", 18, 2386232,
                "Department of economics", 67, 2021)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Antony", "Johnson", 18, 238334,
                "Department of Aircrafting", 100, 2019)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Tom", "Taylor", 18, 2386556,
                "Department of IT", 99, 2020)));
        System.out.println("Студента додано: " + studentsGroup.addMember(new Student("Ann", "Jackson", 18, 123987,
                "Department of IT", 87, 2021)));

        /* Вивід студентів групи з сортуванням
        Сортування відбувається за прізвищами студентів. У випадку якщо прізвища певних студентів співпадають,
        ці студенти будуть сортуватися за іменами. У випадку якщо прізвища та імена певних студентів співпадають
        сортування цих студентів в масиві здійснюється за їх рейтингом (Студент з більшим рейтингом знаходиться
        на позиції вище ніж студент з нижчим рейтингом).
         */
        System.out.print(studentsGroup.toString());
    }
}
