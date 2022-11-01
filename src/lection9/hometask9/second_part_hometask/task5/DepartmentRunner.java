package lection9.hometask9.second_part_hometask.task5;

public class DepartmentRunner {
    public static void main(String[] args) throws CloneNotSupportedException {

        // Робочі посади, що будуть створюватись у відділу
        Department.DepartmentPosition[] departmentPositions = {
                new MiddleDeveloper(),
                new JuniorDeveloper(),
                new SeniorDeveloper()
        };

        // Створення відділу
        Department department = new Department("IT department", "Dale Miller", departmentPositions);

        // Додавання двух нових робітників до відділу
        department.addNewEmployeeToDepartment("John", "Smith", 3);
        department.addNewEmployeeToDepartment("Bob", "Davis", 7);

        // Вивід інформації про всіх робітників відділу
        System.out.println(department.getListOfAllDepartmentMembers());

        // Вивід інформації про відділ
        System.out.println(department);
    }
}
