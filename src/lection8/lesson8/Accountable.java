package lection8.lesson8;

public interface Accountable<T, S> {
    T getId();
    S getSum();
    void setSum(S sum);
}
