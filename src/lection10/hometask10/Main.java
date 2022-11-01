package lection10.hometask10;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static boolean login(String login, String password, String confirmPassword) {
        Pattern pattern = Pattern.compile("\\w{1,20}");
        try {
            if (!pattern.matcher(login).matches()) {
                throw new WrongLoginException("illegal login format");
            }
            if (!pattern.matcher(password).matches() || !pattern.matcher(confirmPassword).matches()) {
                throw new WrongPasswordException("illegal password format");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("unknown password");
            }
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.err.println("Error: " + exception.getMessage());
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter login: ");
        String login = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (login(login, password, confirmPassword)) {
            System.out.println("------Welcome!!!------");
        }
    }
}
