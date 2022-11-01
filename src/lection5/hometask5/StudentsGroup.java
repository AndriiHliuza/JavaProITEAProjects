package lection5.hometask5;

public class StudentsGroup {

    private Student[] students; // Масив для зберігання студентів групи
    private int groupSize; // Максимально допустима кількість студентів в группі

    private int currentNumberOfMembers = 0;  // Поточна кількість студентів в групі

    public StudentsGroup(int groupSize) {
        this.groupSize = groupSize;

        this.students = new Student[groupSize];
    }


    /*
    Метод "addMember" додає студента "student" в кінець масива студентів "students" та повертає "true",
    якщо додавання було можливе, інакше повертає "false".
     */
    public boolean addMember(Student student) {
        if (currentNumberOfMembers == groupSize) {
            return false;
        } else {
            students[currentNumberOfMembers] = student;
            currentNumberOfMembers++;
            return true;
        }
    }


    /*
    Метод "deleteMember" видаляє останнього студента в масиві студентів "students" та повертає "true",
    якщо видалення було можливе, інакше повертає "false".
     */

    public boolean deleteMember() {
        if (currentNumberOfMembers == 0) {
            return false;
        } else {
            students[currentNumberOfMembers-1] = null;
            currentNumberOfMembers--;
            return true;
        }
    }

    /*
    Метод "deleteMember" видаляє студента "student" з масива студентів "students" та повертає "true",
    якщо видалення можливе, інакше повертає "false".
    Якщо студента було видалено, інші студенти масиву "students" здвигаються на одну позицію вліво, до позиції
    видаленого студента включно, а звільнені комірки масиву заповнюються значеннями "null".
     */
    public boolean deleteMember(Student student) {
        if (findStudent(student) != (-1)) {
            shiftStudentsInGroup(findStudent(student));
            currentNumberOfMembers--;
            return true;
        } else {
            return false;
        }


    }

    /*
    Метод "findStudent" шукає студента "student" в масиві студентів "students" та
    повертає індекс студента якщо такий студент існує в масиві або повертіє "-1" якщо такого студента немає в масиві.
     */
    public int findStudent(Student student) {
        int studentPositionInGroup = -1;
        for (int i = 0; i < currentNumberOfMembers; i++) {
            if (students[i].toString().equals(student.toString())) {
                studentPositionInGroup = i;
                break;
            }
        }
        return studentPositionInGroup;
    }

    /*
    Метод "shiftStudentsInGroup" здвигає кожного студента масиву "students" на одну позицію вліво, а
    звільнені комірки заповнюються значеннями "null".
     */
    private void shiftStudentsInGroup(int shiftPosition) {
        for (int i = shiftPosition; i < currentNumberOfMembers-1; i++) {
            students[i] = students[i+1];
        }
        students[currentNumberOfMembers-1] = null;
    }

    /*
    Метод "toString" повертає рядок з відсортованими по прізвищу студентами.
     */
    @Override
    public String toString() {
        Student[] students = sortStudents();
        String group = "";
        for (int i = 0; i < currentNumberOfMembers; i++) {
            group += (i+1) + ") " + students[i].toString() + "\n";
        }
        return group;
    }

    /*
    Метод "sortStudents" сортує масив студентів методом бульбашкового сортування та повертає
    новий відсортований масив "students", довжина якого дорівнює поточній кількості студентів в групі.
    Масив сортується за прізвищами студентів. У випадку якщо прізвища певних студентів співпадають, ці студенти будуть
    сортуватися за іменами. У випадку якщо прізвища та імена певних студентів співпадають сортування цих студентів в
    масиві здійснюється за їх рейтингом (Студент з більшим рейтингом знаходиться на позиції вище ніж студент з
    нижчим рейтингом).
     */
    private Student[] sortStudents() {
        Student[] students = new Student[currentNumberOfMembers];
        Student temp;

        for (int i = 0; i < students.length; i++) {
            students[i] = this.students[i];
        }

        for (int i = students.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (students[j].getSurname().compareTo(students[j+1].getSurname()) > 0) {
                    swapStudents(students, j, j+1);
                } else if (students[j].getSurname().compareTo(students[j+1].getSurname()) == 0) {
                    if (students[j].getName().compareTo(students[j+1].getName()) > 0) {
                        swapStudents(students, j, j+1);
                    } else if (students[j].getName().compareTo(students[j+1].getName()) == 0) {
                        if (students[j].getRating() < students[j+1].getRating()) {
                            swapStudents(students, j, j+1);
                        }
                    }
                }
            }
        }
        return students;
    }

    /*
    Метод "swapStudents" змінює місцями студентів масиву "students", які знаходяться за індексами "firstStudentPosition"
    та "secondStudentPosition" в масиві.
     */
    private static void swapStudents(Student[] students, int firstStudentPosition, int secondStudentPosition) {
        Student temp;
        temp = students[firstStudentPosition];
        students[firstStudentPosition] = students[secondStudentPosition];
        students[secondStudentPosition] = temp;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public int getCurrentNumberOfMembers() {
        return currentNumberOfMembers;
    }
}
