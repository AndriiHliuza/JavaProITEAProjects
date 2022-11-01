package lection9.hometask9.second_part_hometask.task3;

public class AccountRunner {
    public static void main(String[] args) {
        Account account1 = new Account("John"); // Створюємо користувача №1
        Account account2 = new Account("Tom");  // Створюємо користувача №2

        System.out.println(account1);
        System.out.println(account2);


        // Виконуємо операції над рахунком першого користувача
        System.out.println("Операція вдалася: " + account1.makeOperation("income", 2034));
        System.out.println("Операція вдалася: " + account1.makeOperation("withdraw", 300));
        System.out.println("Операція вдалася: " + account1.makeOperation("payment", 234));
        System.out.println("Операція вдалася: " + account1.makeOperation("income", 300));


        System.out.println(account1);

        /*
        Поточний рахунок користувача = 1800 грн.
        Намагаємося зняти з рахунку користувача суму, що перевищує 1800 грн і в результаті отримуємо false (Неможливо проведення поданої операції)
         */
        System.out.println("Операція вдалася: " + account1.makeOperation("withdraw", 2000));

        // Виводимо інформацію про всі операції здійснені з поданим рахунком
        System.out.println(account1.getAllAccountOperations());
    }
}
