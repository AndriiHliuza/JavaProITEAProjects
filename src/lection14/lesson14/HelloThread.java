package lection14.lesson14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HelloThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable task = () -> System.out.println("Hello Thread");

//        Runnable task2 = () -> {
//            System.out.println("Hello Thread");
//        };

//        Runnable task3 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello Thread2");
//            }
//        };


//        new Thread(() -> System.out.println("Hello Thread")).start();

        new Thread(task).start();


        Callable<String> task2 = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                System.out.println("Hello Friend");
                return "Hello World";
            }
        };

        FutureTask<String> future = new FutureTask<>(task2);
        //System.out.println("Future: " + future.get());
        new Thread(future).start();

        System.out.println(future.get());

    }
}

