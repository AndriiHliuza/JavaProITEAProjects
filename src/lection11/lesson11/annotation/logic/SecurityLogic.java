package lection11.lesson11.annotation.logic;

import lection11.lesson11.annotation.SecurityLevelEnum;

import java.lang.reflect.Method;

public class SecurityLogic {
    public void onInvoke(SecurityLevelEnum level, Method method, Object[] args) {
        StringBuilder argsString = new StringBuilder();

        for (Object arg : args) {
            argsString.append(arg.toString() + " :");
        }
        argsString.setLength(argsString.length() - 1);

        System.out.println(String.format("Method %s was invoked with parameters : %s", method.getName(), argsString.toString()));

        switch (level) {
            case LOW -> System.out.println("Низький рівень перевірки безпеки: " + level);
            case NORMAL -> System.out.println("Звичайний рівень перевірки безпеки: " + level);
            case HIGH -> System.out.println("Високий рівень перевірки безпеки: " + level);
        }
    }
}
