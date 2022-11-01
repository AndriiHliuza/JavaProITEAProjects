package lection7.lesson7;


public interface MyData {
    default void print(String str) {
        if (!isNull(str)) {
            System.out.println("My data " + str);
        }
    }
    private boolean isNull(String str) {
        System.out.println("Static method to check null");
        return str == null ? true : "".equals(str) ? true : false;
    }
}
