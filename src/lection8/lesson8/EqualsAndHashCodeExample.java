package lection8.lesson8;

public class EqualsAndHashCodeExample {
    public static void main(String[] args) {
        Simson homer = new Simson(1, "Homer", 35, 120);
        Simson homer2 = new Simson(2, "Homer", 35, 120);

        boolean isHashCodeEquals = homer.hashCode() == homer2.hashCode();

        if (isHashCodeEquals) {
            System.out.println("Слід порівняти методом equals");
        } else {
            System.out.println("Не слід порівнювати методом equals. Об'єкти точні не рівні");
        }
    }
}
