package lection15.hometask15;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Factory {
    private final Semaphore factoryEntryPermit; // семафор, кількість дозволів якого дорівнює кількості під'їздів фабрики
    private final Semaphore permitToLoadContainer = new Semaphore(1);
    private ArrayBlockingQueue<Container> containers;

    public Factory(int numberOfFactoryEntrance, int factoryCapacity) {
        this.factoryEntryPermit = new Semaphore(numberOfFactoryEntrance);
        this.containers = new ArrayBlockingQueue<>(factoryCapacity);
    }

    public ArrayBlockingQueue<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers.addAll(containers);
    }

    public void printContainersInFactory() {
        for (Container container : containers) {
            System.out.println(container);
        }
    }

    public Semaphore getFactoryEntryPermit() {
        return factoryEntryPermit;
    }

    public Semaphore getPermitToLoadContainer() {
        return permitToLoadContainer;
    }

    @Override
    public String toString() {
        return "(Factory) <" +
                ", numberOfContainersInTheFactory: " + containers.size() +
                ", numberOfFreeSpaceInTheFactory: " + containers.remainingCapacity() + ">";
    }
}
