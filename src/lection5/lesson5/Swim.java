package lection5.lesson5;

public interface Swim {
    void swim();

    default String  test() {
        return "good morning";
    }
    default void test2() {
        System.out.println("good evening");
    }
}
