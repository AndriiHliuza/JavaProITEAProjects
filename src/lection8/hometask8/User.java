package lection8.hometask8;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private static int count;
    private int id;
    private String userName;
    private String password;

    private static ArrayList<User> users = new ArrayList<>();

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        id = ++count;
        users.add(this);
    }

    public void deleteFromUserList() {
        users.remove(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public void addToUserList() {

    }

    /**
     * Checks if user is in the user list
     */
    public void login() {
        boolean isInUserList = false;
        for (User user : users) {
            if (this.equals(user) && id == user.id) {
                isInUserList = true;
            }
        }
        if (isInUserList) {
            System.out.println("Ім'я користувача та пароль збігаються");
        } else {
            System.out.println("Ім'я користувача та пароль не збігаються");
        }
    }

    /**
     * Compares two users names and passwords
     * @param user user to compare
     */
    public void login(User user) {
        if (this.equals(user)) {
            System.out.println("Ім'я користувача та пароль збігаються");
        } else {
            System.out.println("Ім'я користувача та пароль не збігаються");
        }
    }

    /**
     * Compares user1's name and password to user2's name and password
     * @param user1 First user
     * @param user2 Second user
     */
    public static void login(User user1, User user2) {
        if (user1.equals(user2)) {
            System.out.println("Ім'я користувача та пароль збігаються");
        } else {
            System.out.println("Ім'я користувача та пароль не збігаються");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    public static void main(String[] args) {
        User user1 = new User("John", "123456");
        User user2 = new User("Bob", "123456");
        User user3 = new User("John", "123456");

        user1.login();
        user2.login();
        user3.login();

        System.out.println("\n----------------\n");

        user1.login(user2);
        user1.login(user3);

        System.out.println("\n----------------\n");

        login(user1, user2);
        login(user1, user3);

    }
}
