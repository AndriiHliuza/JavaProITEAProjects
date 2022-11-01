package lection10.lesson10;

public class NestedTryCatchRunner {

    public void doAction() {
        try {
            int a = (int)(Math.random() * 2) - 1;
            System.out.println("a = " + a);
            throw new IllegalArgumentException();
//            try {
//                int b = 1 / a;
//                StringBuilder stringBuilder = new StringBuilder(a);
//            } catch (NegativeArraySizeException e) {
//                System.err.println("illegal buffer size: " + e);
//            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("division by 0: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("hello");
        }
    }
}
