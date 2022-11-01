package lection9.hometask9.second_part_hometask.task3;

/*
3. Створити клас Account з внутрішнім класом,
за допомогою об'єктів якого можна зберігати інформацію про всі операції з рахунком (зняття, платежі, надходження).
Створені класи до завдання:
  - Account.java
  - AccountRunner.java
 */

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private static int count;
    private ArrayList<Operation> allAccountOperations = new ArrayList<>(); // Список всіх операцій здійснених власником рахунку
    private int id; // Номер власника рахунку у списку всіх користувачів
    private String name; // Ім'я користувача
    private double amountOfMoney; // Поточна сума на рахунку власника

    public Account(String name) {
        this.id = ++count;
        this.name = name;
    }

    /**
     * Метод для отримання всіх операцій здійснених користувачем
     * @return Строкове представлення всіх операцій, що здійснював власник рахунку
     */
    public String getAllAccountOperations() {
        String allAccountOperations = "";
        for (Operation operation : this.allAccountOperations) {
            allAccountOperations += operation + "\n";
        }
        return allAccountOperations;
    }

    private class Operation {
        private int operationNumber; // Номер операції у списку всіх операцій власника рахунку
        private TypeOfOperation typeOfOperation; // Тип операції, яку можна здійснити
        private Date dataOfOperation; // Дата здійснення операції
        private double amountOfMoneyToOperate; // Сума грощей яку хочуть зняти або додати до рахунку користувача

        private double amountOfRemainingMoneyAfterOperation; // Сума грошей, що залишилася на рахунку користувача після здійснення поточної операції

        public Operation(TypeOfOperation typeOfOperation, double amountOfMoneyToOperate) {
            this.operationNumber = allAccountOperations.size() + 1;
            this.typeOfOperation = typeOfOperation;
            this.dataOfOperation = new Date();
            this.amountOfMoneyToOperate = amountOfMoneyToOperate;

            amountOfRemainingMoneyAfterOperation = switch (typeOfOperation) {
                case WITHDRAW, PAYMENT -> amountOfMoney -= amountOfMoneyToOperate;
                case INCOME -> amountOfMoney += amountOfMoneyToOperate;
            };
        }
        private enum TypeOfOperation {
            WITHDRAW,
            PAYMENT,
            INCOME;

            /**
             * Метод для перевірки існування вказвної операції
             * @param typeOfOperation Операція, яку потрібно перевірити на існування в списку доступних операцій
             * @return true - Якщо подана операція існує
             *         false - Якщо поданої операції не існує
             */
            private static boolean isPresent(String typeOfOperation) {
                for (TypeOfOperation operation : values()) {
                    if (typeOfOperation.equalsIgnoreCase(operation.toString())) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override
        public String toString() {
            return "Operation №" + operationNumber + " {" +
                    "Тип операції: " + typeOfOperation +
                    ", Дата здійснення операції: " + dataOfOperation +
                    ", Сума переводу: " + amountOfMoneyToOperate +
                    " грн., Сума грошей, що залишилася на рахунку після операції: " + amountOfRemainingMoneyAfterOperation + " грн.}";
        }
    }

    /**
     * Метод для здійснення операцій з рахунком власника
     * @param typeOfOperation Тип операції, якя можна здійснювати над рахунком користувача
     *                        Доступні операції:
     *                        1) Зняття коштів з рахунку в банкоматі (WITHDRAW)
     *                        2) Зняття коштів з рахунку шляхом платежу (PAYMENT)
     *                        3) Надходження коштів на рахунок коритсувача (INCOME)
     * @param amountOfMoneyToOperate Сума коштів над яку хочуть зняти з рахунку або додати до рахунку користувача
     *                               Операція над поданою сумою коштів залежить від вибраної операції
     * @return true: Якщо операція було проведено успішно
     *         false:
     *         1) Якщо користувачем вибрана операція яка недоступна по замовчуванню
     *            (Операції доступні по замовчуванню: WITHDRAW, PAYMENT, INCOME)
     *         2) Якщо користувач вибрав операцію WITHDRAW або PAYMENT але поточна сума на рахунку користувача менше суми зняття коштів з рахунку
     *         3) Якщо сума коштів, яку хочу зняти з рахунку або додати до рахунку дорівнює 0 або менша за 0
     */
    public boolean makeOperation(String typeOfOperation, double amountOfMoneyToOperate) {
        if ((amountOfMoneyToOperate <= 0) || (!Operation.TypeOfOperation.isPresent(typeOfOperation)) ||
                ((Operation.TypeOfOperation.valueOf(typeOfOperation.toUpperCase()) == Operation.TypeOfOperation.WITHDRAW ||
                        Operation.TypeOfOperation.valueOf(typeOfOperation.toUpperCase()) == Operation.TypeOfOperation.PAYMENT)
                        && (amountOfMoney < amountOfMoneyToOperate))) {
            return false;
        }
        allAccountOperations.add(new Operation(Operation.TypeOfOperation.valueOf(typeOfOperation.toUpperCase()), amountOfMoneyToOperate));
        return true;
    }

    @Override
    public String toString() {
        return "Account №" + id + " {" +
                "Ім'я: " + name + ", " +
                "Сума на рахунку: " + amountOfMoney + " грн.}";
    }
}
