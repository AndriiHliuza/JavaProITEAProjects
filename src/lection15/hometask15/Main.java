package lection15.hometask15;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory(3, 5);
        factory.setContainers(Container.generateListOfContainers(new Random().nextInt(0, 6)));

        System.out.println("-------------------------Factory and its containers before doing operations-------------------------");
        System.out.println("        " + factory + "          ");
        factory.printContainersInFactory();

        ArrayList<Train> trains = Train.generateTrains(5, factory);

        for (Train train : trains) {
            train.load(Container.generateListOfContainers(new Random().nextInt(0, train.getContainersInTheTrain().remainingCapacity())));
        }

        System.out.println("\n\n\n");
        System.out.println("-------------------------All trains and their containers before doing operations-------------------------");

        for (Train train : trains) {
            System.out.println("        " + train + "          ");
            train.printContainersInTrain();
            System.out.println();
        }

        System.out.println("\n\n\n");
        System.out.println("-------------------------All trains has started doing their operations-------------------------");

        for (Train train : trains) {
            train.start();
        }

        for (Train train : trains) {
            try {
                train.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("\n\n\n");
        System.out.println("-------------------------All trains and their containers after doing their operations-------------------------");

        for (Train train : trains) {
            System.out.println("        " + train + "          ");
            train.printContainersInTrain();
            System.out.println();
        }

        System.out.println("\n\n\n");
        System.out.println("-------------------------Factory and its containers after doing operations-------------------------");
        factory.printContainersInFactory();

    }
}
