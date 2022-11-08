package lection14.lesson14;

import java.util.HashMap;

public class HelloHashMap {
    public static void main(String[] args) {
        HashMap<String, Float> salaryMap = new HashMap<>();

        salaryMap.put("E01", 1000f);
        salaryMap.put("E02", 12000f);
        salaryMap.put("E03", 12300f);
        salaryMap.put("E04", 1000f);
        System.out.println(salaryMap.put("E05", 300.5f));

        Float salary = salaryMap.get("E01");
        System.out.println("Salary of employee E01 = " + salary);

        System.out.println("Salary of employee E05 = " + salaryMap.get("E05"));
        System.out.println(salaryMap.put("E05", 400f));
        System.out.println("Salary of employee E05 = " + salaryMap.get("E05"));
    }
}
