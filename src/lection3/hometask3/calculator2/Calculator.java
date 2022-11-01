package lection3.hometask3.calculator2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer;
        do {
            System.out.print("""
                    -------- Calculator has started --------
                    Доступні операції:
                    1. + (Додавання)
                    2. - (Віднімання)
                    3. * (Множення)
                    4. / (Ділення)
                    5. % (Ділення по модулю)

                    """);
            boolean isOperation = false; // Змінна для чергування вводу числа та операції
            boolean isFirstNumber = true; // Змінна для визначення того чи є введене число першим введеним в калькулятор

            String operationStr = ""; // Змінна в яку записується введена операція
            String nextNumStr;  /* Змінна в яку записується друге число (Тимчасово зберігає перше число при першому
                                   запуску програми
                                */


            double nextNum = 0;  /* Змінна в яку записується друге число (Тимчасово зберігає перше число при першому
                                    запуску програми
                                 */
            double result = 0;   // Змінна для зберігання першого числа та результату

            System.out.println("--- Start --- (If you want to get final result, print '=')");
            do {
                if (isOperation) {
                    System.out.print("Print operation...-> ");
                    operationStr = getValue();
                    if (isCorrectOperation(operationStr)) {
                        operationStr = operationStr.trim();
                        if (isFirstNumber) {
                            isFirstNumber = false; /* Змінюємо значення змінної isFirstNumber на false після
                                                      введення першої операції в калькуляторі
                                                   */
                        }
                    } else if (operationStr.matches("\\s*(=)\\s*")) {
                        break;
                    } else {
                        System.out.print("""
                                ------ Невірно введені дані ------
                                Доступні варіанти вводу
                                1. "+" (Додавання)
                                2. "-" (Віднімання)
                                3. "*" (Множення)
                                4. "/" (Ділення)
                                5. "%" (Ділення по модулю)
                                6. "=" (Для виводу результату)
                                """);
                        break;
                    }

                    isOperation = false;
                } else {
                    System.out.print("Print number......-> ");
                    nextNumStr = getValue();
                    if (isCorrectNumber(nextNumStr)) {

                        nextNumStr = nextNumStr.replace(",", "."); /* Змінюємо запис
                                                                                       числа з плаваючою комою
                                                                                       на число з плаваючою точкою
                                                                                    */

                        nextNum = Double.parseDouble(nextNumStr); // Переводимо строкове представлення числа в числове
                        if (isFirstNumber) {
                            result = nextNum;
                        } else {

                            // Перевіряємо можливий випадок ділення числа на нуль
                            if (nextNum == 0 && operationStr.equals("/")) {
                                System.out.print("""
                                        ------Помилка ділення на нуль------
                                        """);
                                break;
                            }


                            result = calculate(result, nextNum, operationStr);
                            System.out.println("......Проміжний результат......: " + result);
                        }
                    } else if (nextNumStr.matches("\\s*(=)\\s*")) {
                        break;
                    } else {
                        System.out.print("""
                                ------ Невірно введені дані ------
                                Доступні варіанти вводу:
                                1. Число (Для проведення подальших обчислень)
                                2. "=" (Для виводу результату)
                                """);
                        break;
                    }
                    isOperation = true;
                }

            } while (true);
            if (!(nextNum == 0 && operationStr.equals("/"))) {
                System.out.println("......ФІНАЛЬНИЙ РЕЗУЛЬТАТ......: " + result);  // Вивід результату обрахунку
            }
            System.out.print("Press 'q' to exit or press 's' to start again -> ");
            userAnswer = scanner.nextLine();
        } while (userAnswer.matches("\\s*([sS])\\s*")); // Перевіряємо чи не ввів користувач "S" або "s"
    }



    // Метод для обрахунку
    public static double calculate(double firstNum, double secondNum, String operation) {
        double result = 0;
            switch (operation) {
                case "+" :
                    result = firstNum + secondNum;
                    break;
                case "-" :
                    result = firstNum - secondNum;
                    break;
                case "*" :
                    result = firstNum * secondNum;
                    break;
                case "/" :
                    result = firstNum / secondNum;
                    break;
            }
        return result;
    }


    // Метод для вводу значення (операції / числа)
    public static String getValue() {
        //System.out.print("Print operation...-> ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }


    // Метод для перевірки правильності введеної операції
    public static boolean isCorrectOperation(String operation) {
        if (operation.matches("\\s*([+\\-*/])\\s*")) {
            return true;
        } else {
            return false;
        }
    }

    // Метод для перевірки правильності введеного числа
    public static boolean isCorrectNumber(String number) {
        if (number.matches("\\s*([0-9]+([,.])?[0-9]*)\\s*")) {
            return true;
        } else {
            return false;
        }
    }

}
