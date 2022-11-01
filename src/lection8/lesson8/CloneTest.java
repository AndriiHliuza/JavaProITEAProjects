package lection8.lesson8;

public class CloneTest {

    public static class Car {
        public String color;

        public Car(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }

    static class Person implements Cloneable {
        String name;
        int age;
        Car car;

        public Person(String name, int age, Car car) {
            this.name = name;
            this.age = age;
            this.car = car;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", car=" + car +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Car car = new Car("Green");
        Person person = new Person("Mike", 25, car);

        Person clone = (Person) person.clone();

        System.out.println(person);
        System.out.println(clone);

        clone.name = "Ivan";
        clone.car.color = "red";

        System.out.println(person);
        System.out.println(clone);
    }
}
