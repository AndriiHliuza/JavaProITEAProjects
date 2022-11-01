package lection9.hometask9.second_part_hometask.task4;

/*
4. Створити клас Залікова Книжка з внутрішнім класом, за допомогою об'єктів якого можна зберігати інформацію про сесії, заліках, іспитах.
Створені класи до завдання:
  - GradeBook.java
  - GradeBookRunner.java
  - Student.java
  - Tutor.java
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class GradeBook {

    private ArrayList<Tutor> tutors = new ArrayList<>();
    private static int count;
    private int gradeBookNumber; // Номер залікової книжки студента
    private LocalDate dateOfIssue; // Дата видачі залікової книжки студенту
    private Student student; // Студент, що володіє поданою заліковою книжкою

    /*
    Список екзаменів, сесій та іспитів які склав студент
     */
    private ArrayList<StudentGradeActivity> studentGradeActivities = new ArrayList<>();

    public GradeBook(Student student) {
        this.gradeBookNumber = ++count;
        this.dateOfIssue = LocalDate.now();
        this.student = student;
    }

    /**
     * Клас StudentGradeActivity представляє вид контролю оцінок студентів
     * Можливі контролі оцінок студентів:
     * 1) Контроль через екзамен
     * 2) Контроль через сесію
     * 3) Контроль через іспит
     */
    private class StudentGradeActivity {
        private int course; // курс на якому складався іспит
        private int semester; // семестр на якому складався іспит
        private double grade; // Отримана оцінка за іспит
        private Tutor tutor; // Викладач, що приймав іспит
        private String nameOfSubject; // Дисципліна з якої складався іспит

        /*
        Тип іспиту:
        1) Іспит (TEST)
        2) Сесія (SESSION)
        3) Екзамен (EXAM)
         */
        private StudentGradeActivitiesTypes studentGradeActivitiesType;

        public StudentGradeActivity(String tutorName, String nameOfSubject, StudentGradeActivitiesTypes studentGradeActivitiesType) {
            this.course = LocalDate.now().getYear() - student.getYearOfEntry() + 1; // Курс = рік складання іспиту - рік вступу
            setSemester();
            this.tutor = getTutorForExam(tutorName);
            grade = tutor.setGrade();
            this.nameOfSubject = nameOfSubject;
            this.studentGradeActivitiesType = studentGradeActivitiesType;
        }

        private Tutor getTutorForExam(String tutorName) {
            for (int i = 0; i < tutors.size(); i++) {
                if (tutorName.equals(tutors.get(i).getName())) {
                    return tutors.get(i);
                }
            }
            Tutor tutor = new Tutor(tutorName);
            tutors.add(tutor);
            return tutor;
        }

        /**
         * Метод setSemester() визначає семестр складання іспиту на основі дати складання іспиту (поточної дати)
         */
        private void setSemester() {
            if (LocalDate.now().getDayOfMonth() <= 6) {
                semester = 1;
            } else {
                semester = 2;
            }
        }

        /**
         * Види іспитів:
         * 1) Сесія (SESSION)
         * 2) Іспит (TEST)
         * 3) Екзамен (EXAM)
         */
        private enum StudentGradeActivitiesTypes {
            SESSION,
            TEST,
            EXAM;

            /**
             * Метод для перевірки існування вказаного типу іспиту
             * @param typeOfGradeActivity Тип іспиту який потрібно перевірити на існування в списку доступних типів
             * @return true - Якщо поданий тип іспиту існує
             *         false - Якщо поданого типу іспиту не існує
             */
            private static boolean isPresent(String typeOfGradeActivity) {
                for (StudentGradeActivitiesTypes studentGradeActivitiesType : values()) {
                    if (typeOfGradeActivity.equalsIgnoreCase(studentGradeActivitiesType.toString())) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override
        public String toString() {
            return  "Курс №" + course +
                    ", Семестр: №" + semester +
                    ", Викладач: " + tutor +
                    ", Назва дисципліни: " + nameOfSubject +
                    String.format(", Оцінка: %.2f", grade) +
                    ", Тип контролю: " + studentGradeActivitiesType;
        }
    }

    /**
     * Метод для запису іспиту в залікову книжку студента
     * @param studentGradeActivityType Тип складуваного іспиту (SESSION, TEST, EXAM)
     * @param tutorName Ім'я викладача, що приймав іспит
     * @param nameOfSubject Предмет з якого складається іспит
     */
    public void createStudentGradeActivity(String studentGradeActivityType, String tutorName, String nameOfSubject) {
        if (StudentGradeActivity.StudentGradeActivitiesTypes.isPresent(studentGradeActivityType)) {
            studentGradeActivities.add(new StudentGradeActivity(tutorName, nameOfSubject,
                    StudentGradeActivity.StudentGradeActivitiesTypes.valueOf(studentGradeActivityType.toUpperCase())));
        }
    }

    /**
     * Метод для отримання списку всіх іспитів, що записані в заліковій книжці студента
     * @return Список всіх іспитів, що записані в заліковій книжці студента
     */
    public String getGradeBookInfo() {
        String allStudentGradeBookActivities = "";
        for (StudentGradeActivity studentGradeActivity : studentGradeActivities) {
            allStudentGradeBookActivities += studentGradeActivity + "\n";
        }
        return allStudentGradeBookActivities;
    }

    @Override
    public String toString() {
        return "Номер залікової книжки: " + gradeBookNumber +
                ", Дата видачі залікової книжки: " + dateOfIssue +
                ", Студент: " + student.getName() + " " + student.getSurname();
    }

    public ArrayList<Tutor> getTutors() {
        return tutors;
    }
}
