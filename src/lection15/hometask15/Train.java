package lection15.hometask15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Train extends Thread {

    private final int trainId;
    private final double maxWeightToCarry;  // вантажопідйомність потяга
    private double currentWeightOfContainersInTheTrain; // поточна вага, яку перевозить потяг
    private final ArrayBlockingQueue<Container> containersInTheTrain;
    private final Factory factory;
    private final Semaphore semaphoreToLoadAndUnload = new Semaphore(1);

    public Train(int trainId, double maxWeightToCarry, int trainCapacity, Factory factory) {
        this.trainId = trainId;
        this.maxWeightToCarry = maxWeightToCarry;
        this.containersInTheTrain = new ArrayBlockingQueue<>(trainCapacity);
        this.factory = factory;
    }

    private void load(int numberOfContainersToLoad) {
        for (int i = 0; i < numberOfContainersToLoad; i++) {
            try {

                factory.getPermitToLoadContainer().acquire();

                Container container = factory.getContainers().peek();
                if (container != null && maxWeightToCarry >= (container.getWeight() + currentWeightOfContainersInTheTrain) && containersInTheTrain.offer(container)) {
                    factory.getContainers().poll();
                    currentWeightOfContainersInTheTrain += container.getWeight();
                    System.out.format("%-136s <- (Successful operation)\n", "   Train " + trainId + " has loaded " + container);
                } else if (container == null) {
                    System.out.format("%-136s <- [Error while loading]\n", "   Unable to load container to train " + trainId +  " because factory is empty");
                } else if (containersInTheTrain.remainingCapacity() == 0) {
                    System.out.format("%-136s <- [Error while loading]\n", "   Unable to load '" + container + "' to train " + trainId +  " because train is full");
                } else if (maxWeightToCarry < (container.getWeight() + currentWeightOfContainersInTheTrain)) {
                    System.out.format("%-136s <- [Error while loading]\n", "   Unable to load '" + container + "' to train " + trainId + " because the weight of container is to big");
                }

                factory.getPermitToLoadContainer().release();

            } catch (InterruptedException e) {
                System.out.println("Loading -> " + " train " + trainId + ": " + e.getMessage());
            }
        }
    }
    private void unload(int numberOfContainersToUnload) {
        for (int i = 0; i < numberOfContainersToUnload; i++) {
            Container container = containersInTheTrain.peek();
            if (container != null && factory.getContainers().offer(container)) {
                currentWeightOfContainersInTheTrain -= container.getWeight();
                containersInTheTrain.poll();
                System.out.format("%-136s <- (Successful operation)\n", "   Train " + trainId + " has unloaded " + container);
            } else if (container == null) {
                System.out.format("%-136s <- [Error while unloading]\n", "   Unable to unload container from the train " + trainId + " because train is empty");
            } else {
                System.out.format("%-136s <- [Error while unloading]\n", "   Unable to unload '" + container + "' from the train " + trainId + " because factory is full");
            }
        }
    }



    @Override
    public void run() {
        try {

            factory.getFactoryEntryPermit().acquire();

            double random = Math.random();
            if (random < 0.5) {

                System.out.println(" (Train " + trainId + " operation: UNLOADING)");
                int numberOfContainersToUnload = (int) (Math.random() * containersInTheTrain.size());
                System.out.println("Train " + trainId + " is going to unload " + numberOfContainersToUnload + " container(s)");
                unload(numberOfContainersToUnload);

            } else if (random < 0.7){

                System.out.println(" (Train " + trainId + " operation: LOADING)");
                int numberOfContainersToLoad = (int) (Math.random() * containersInTheTrain.size());
                System.out.println("Train " + trainId + " is going to load " + numberOfContainersToLoad + " container(s)");
                load(numberOfContainersToLoad);

            } else {

                System.out.println(" (Train " + trainId + " operation: UNLOADING and LOADING)");
                Thread t1 = new Thread(() -> {
                    try {
                        semaphoreToLoadAndUnload.acquire();
                        int numberOfContainersToUnload = (int) (Math.random() * containersInTheTrain.size());
                        System.out.println("Train " + trainId + " is going to unload " + numberOfContainersToUnload + " container(s)");
                        unload(numberOfContainersToUnload);
                        semaphoreToLoadAndUnload.release();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " : " + e.getMessage());
                    }

                });
                Thread t2 = new Thread(() -> {
                    try {
                        semaphoreToLoadAndUnload.acquire();
                        int numberOfContainersToLoad = (int) (Math.random() * containersInTheTrain.size());
                        System.out.println("Train " + trainId + " is going to load " + numberOfContainersToLoad + " container(s)");
                        load(numberOfContainersToLoad);
                        semaphoreToLoadAndUnload.release();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " : " + e.getMessage());
                    }
                });

                t1.start();
                t2.start();

                t1.join();
                t2.join();

            }
            System.out.println(" (Train " + trainId + " finished operations)");
            factory.getFactoryEntryPermit().release();

        } catch (InterruptedException e) {
            System.err.println("Train " + trainId + " exception");
        }
    }

    public void load(List<Container> list) {
        for (Container container : list) {
            if (maxWeightToCarry > (container.getWeight() + currentWeightOfContainersInTheTrain)) {
                containersInTheTrain.offer(container);
                currentWeightOfContainersInTheTrain += container.getWeight();
            }
        }
    }

    public ArrayBlockingQueue<Container> getContainersInTheTrain() {
        return containersInTheTrain;
    }

    public void printContainersInTrain() {
        for (Container container : containersInTheTrain) {
            System.out.println("- " + container);
        }
    }

    public static ArrayList<Train> generateTrains(int numberOfTrainsToGenerate, Factory factory) {
        ArrayList<Train> trains = new ArrayList<>();
        for (int i = 0; i < numberOfTrainsToGenerate; i++) {

            double maxWeightToCarry = new Random().nextInt(20, 200);
            int trainCapacity = new Random().nextInt(1, 10);

            trains.add(new Train((i + 1), maxWeightToCarry, trainCapacity, factory));
        }
        return trains;
    }


    @Override
    public String toString() {
        return "(Train) <" +
                "trainId: " + trainId +
                ", maxWeightToCarry: " + maxWeightToCarry +
                ", numberOfContainersInTheTrain: " + containersInTheTrain.size() +
                ", numberOfFreeSpaceInTheTrain: " + containersInTheTrain.remainingCapacity() + ">";
    }
}
