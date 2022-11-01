package lection8.lesson8;

public class Account<T, S> implements Accountable<T, S> {
    private T id;
    private S sum;

    private String ttt;

    public <V> Account(T id, S sum, V ttt) {
        this.id = id;
        this.sum = sum;
        this.ttt = ttt.toString();
    }

    public String getTtt() {
        return ttt;
    }

    public T getId() {
        return id;
    }


    public S getSum() {
        return sum;
    }

    public void setSum(S sum) {
        this.sum = sum;
    }
}

//public class Account {
//    private String id;
//    private int sum;
//
//    public <T> Account(T id, int sum) {
//        this.id = id.toString();
//        this.sum = sum;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//
//    public int getSum() {
//        return sum;
//    }
//
//    public void setSum(int sum) {
//        this.sum = sum;
//    }
//}
