package lection3.hometask3.calculator1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        calculator(); // Запускаємо калькулятор
    }
    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        String userAnswer; // Змінна для зберігання відповіді користувача: Запускати калькулятор чи ні
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
            double result = 0; // Змінна для зберігання результату операції (першого операнду)
            double nextNum = 0; // Змінна для зберігання другого операнда операції
            String operation = null; // Змінна для зберігання введеної операції
            boolean isOperation = false; // Змінна для перевірки почерговості введення: операнд - операція
            boolean isFirstNumber = true; // Змінна для перевірки того чи є введений операнд першим введеним операндом в калькуляторі
            System.out.println("--- Start --- (If you want to get final result, print '=')");
            System.out.print("Print number......-> ");
            while (!scanner.hasNext("=")) {

                /*
                При isOperation = true здійснюється ввід операції
                При isOperation = false здійснюється ввід числа
                 */
                if (isOperation) {

                    /*
                    Перевірка вводу правильної операції
                        Якщо операція правильна, то калькулятор зберігає введену операцію в змінну operation
                        Якщо операція не правильна, то калькулятор виводить повідомлення про невірно введені дані
                        та завершує виконання операцій
                     */
                    if (scanner.hasNext("\\+") || scanner.hasNext("-")
                            || scanner.hasNext("\\*") || scanner.hasNext("/")
                            || scanner.hasNext("%")) {
                        operation = scanner.next();
                        scanner.nextLine();

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

                        /*
                        Якщо калькулятор визначив неправильно введену операцію, то здійснюється перевірка на те
                        чи було попереднє введене число першим числом введеним в калькулятор і якщо це так то
                        калькулятор зберігає це число як результат та завершує виконання підрахунку
                         */
                        if (isFirstNumber) {
                            result = nextNum;
                        }
                        break;
                    }
                    /*
                    Якщо поперенє введене число було першим введеним числом в калькуляторі, то
                    це число зберігається як результат, а значення змінної isFirstNumber змінюється на false таким
                    чином позначаючи, що подальші введені числа вже не будуть першими введеними в калькулятор числами
                     */
                    if (isFirstNumber) {
                        result = nextNum;
                        isFirstNumber = false;
                    }
                    isOperation = false;  // Надаємо право вводу чисел
                } else {

                    /*
                    Перевірка вводу числа
                        Якщо було введено число, то калькулятор зберігає введене число в змінну nexNum
                        Якщо було введене не правильне число, то калькулятор виводить повідомлення про невірно введені
                        дані та завершує виконання операцій
                     */
                    if (scanner.hasNextDouble()) {
                        nextNum = scanner.nextDouble();
                        scanner.nextLine();
                    } else {
                        System.out.print("""
                                
                                ------ Невірно введені дані ------
                                Доступні варіанти вводу:
                                1. Число (Для проведення подальших обчислень)
                                2. "=" (Для виводу результату)
                                
                                """);
                        break;
                    }

                    /*
                    Блок коду, що обраховує введені значення
                     */
                    if (!isFirstNumber) {
                        switch (operation) {
                            case "+" :
                                result += nextNum;
                                break;
                            case "-" :
                                result -= nextNum;
                                break;
                            case "*" :
                                result *= nextNum;
                                break;
                            case "/" :
                                result /= nextNum;
                                break;
                            case "%" :
                                result %= nextNum;
                                break;
                        }
                        System.out.println("......Проміжний результат......: " + result);
                    }
                    isOperation = true; // Надаємо право вводу операції

                }

                // В залежності від почерговості вводу: операція - число, виводимо запрошення на ввід числа або операції
                if (isOperation) {
                    System.out.print("Print operation...-> ");
                } else {
                    System.out.print("Print number......-> ");
                }

                /*
                Якщо в поле для першого вводу операції користувач пише "=", то ми зберігаємо попереднє (воно ж перше)
                введене чило в змінну result та завершуємо обчислення
                 */
                if (isFirstNumber && scanner.hasNext("=")) {
                    result = nextNum;
                    break;
                }

            }

            /*
            Вивід результату та вивід запрошення на повторне використання калькулятора
             */
            scanner.nextLine();
            System.out.println("......ФІНАЛЬНИЙ РЕЗУЛЬТАТ......: " + result);
            System.out.print("Press 'q' to exit or press 's' to start again -> ");
            userAnswer = scanner.nextLine();
        } while(userAnswer.equalsIgnoreCase("S") || userAnswer.matches("\\s*(s)\\s+(.*)"));
    }
}
