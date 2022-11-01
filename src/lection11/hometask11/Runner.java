package lection11.hometask11;

public class Runner {

    public static void run(Running running) {
        Repeat repeat = running.getClass().getAnnotation(Repeat.class);

        if (repeat != null) {
            for (int i = 0; i < repeat.value(); i++) {
                System.out.println(repeat.phrase());
            }
        } else {
            System.err.println("There is no annotation for " + running);
        }
    }


    public static void main(String[] args) {
        run(new MyRunnable());
    }
}
