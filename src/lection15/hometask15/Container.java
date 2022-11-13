package lection15.hometask15;

import java.util.ArrayList;
import java.util.Random;

public class Container {
    private final double weight;
    private ContainerContentType containerContentType;

    public Container(double weight, ContainerContentType containerContentType) {
        this.weight = weight;
        this.containerContentType = containerContentType;
    }

    public enum ContainerContentType {
        METAL,  // метал
        PRODUCT // готовий виріб
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Container -> " +
                "weight: " + weight +
                ", type: " + containerContentType;
    }

    public static ArrayList<Container> generateListOfContainers(int numberOfContainersToGenerate) {
        ArrayList<Container> containers = new ArrayList<>();
        for (int i = 0; i < numberOfContainersToGenerate; i++) {
            if (Math.random() < 0.5) {
                containers.add(new Container(new Random().nextInt(10, 65), ContainerContentType.METAL));
            } else {
                containers.add(new Container(new Random().nextInt(10, 65), ContainerContentType.PRODUCT));
            }
        }
        return containers;
    }
}
